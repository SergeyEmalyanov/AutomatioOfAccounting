import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
public class ReportsApp {
    HashMap<String, MonthlyReport> monthlyReports;
    String[] months;
    String pathToFolder;
    ReportsApp () {
        monthlyReports = new HashMap<>();
        months = new String[]{"Январь", "Февраль", "Март"};
        pathToFolder = "D:\\JAVA\\Project_Idea\\Automation of accounting\\";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    void readAndSaveMonthlyReports () {
        String path;
        for (int j=1; j<=3; j++) {
            String a = Integer.toString(j);
            if (j <= 10) {
                path = pathToFolder + "m.20220" + a + ".csv";
            } else {
                path = pathToFolder + "m.2022" + a + ".csv";
            }

            String contents = readFileContentsOrNull(path);
            String[] lines = contents.split("\\n");
            int linesLength= lines.length;
            monthlyReports.put(months[j - 1], new MonthlyReport(linesLength));
            for (int i = 0; i < lines.length; i++) {
                String[] lineContent = lines[i].split(";");
                String itemName=lineContent[0];
                boolean isExpense=Boolean.parseBoolean(lineContent[1]);
                int quantity=Integer.parseInt(lineContent[2]);
                int sumOfOne=Integer.parseInt(cutLastValueInString(lineContent[3], linesLength, i));
                monthlyReports.get(months[j - 1]).setMonthlyReport(itemName,isExpense,quantity,sumOfOne);
            }

        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    void printMonthlyReport(){
        for(int i=0; i<3;i++){
            monthlyReports.get(months[i]).setExAndInAndMaxOfMonth();
            MonthlyReport printMonthlyReport=monthlyReports.get(months[i]);
            String print;
            for (int j=0; j<3;j++){
                String itemName=printMonthlyReport.getItemName(j);
                String isExpense=expenseOrIncome(printMonthlyReport.getIsExpense (j));
                int quantity=printMonthlyReport.getQuantity (j);
                int sumOfOne=printMonthlyReport.getSumOfOne (j);
                int sum=quantity*sumOfOne;
                print="Категория: "+itemName+" " +isExpense + "ы Количество: "+quantity+" Цена ед.: "+sumOfOne+" Сумма: "+sum;
                System.out.println(print);
            }
            System.out.println("Всего расход: "+printMonthlyReport.getMonthlyExpenses());
            System.out.println("Всего доход: "+printMonthlyReport.getMonthlyIncome());
            int numberOfMaxCategory=printMonthlyReport.getCategoryOfMaxMonthlyExpenses();
            System.out.println(stringMax(numberOfMaxCategory,i));
            numberOfMaxCategory=printMonthlyReport.getCategoryOfMaxMonthlyIncome();
            System.out.println(stringMax(numberOfMaxCategory,i));
        }

    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    String stringMax (int numberOfMaxCategory, int i){
        MonthlyReport printMax=monthlyReports.get(months[i]);
        String printExOrIn=expenseOrIncome(printMax.getIsExpense(numberOfMaxCategory));
        String ItemName=printMax.getItemName(numberOfMaxCategory);
        Integer quantity=printMax.getQuantity (numberOfMaxCategory);
        Integer sumOfOne=printMax.getSumOfOne (numberOfMaxCategory);
        int sum=quantity*sumOfOne;
        return ("Наибольший "+printExOrIn+" в категории: "+ItemName+" Сумма: "+ sum);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    String expenseOrIncome (boolean expenseOrIncome ){
        if (expenseOrIncome){
            return ("расход");
        }else{
            return ("доход");

        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    String cutLastValueInString (String lineContent, int linesLength, int i) {
        if (linesLength - 1 == i) {
            return (lineContent);
        } else {
            char[] strToArray = lineContent.toCharArray();
            String lastValueInString = "";
            for (int j = 0; j < strToArray.length - 1; j++) {
                lastValueInString += strToArray[j];
            }
            return (lastValueInString);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    String readFileContentsOrNull (String path){
        try {
            return (Files.readString(Paths.get(path)));
        }catch (IOException ex) {
            return (ex.getMessage());
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

}