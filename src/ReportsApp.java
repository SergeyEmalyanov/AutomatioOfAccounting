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
            monthlyReports.put(months[j - 1], new MonthlyReport(lines.length));
            for (int i = 0; i < lines.length; i++) {
                String[] lineContent = lines[i].split(";");
                monthlyReports.get(months[j - 1]).itemName[i] = lineContent[0];
                monthlyReports.get(months[j - 1]).isExpense[i] = Boolean.parseBoolean(lineContent[1]);
                monthlyReports.get(months[j - 1]).quantity[i] = Integer.parseInt(lineContent[2]);
                monthlyReports.get(months[j-1]).sumOfOne[i] = Integer.parseInt(cutLastValueInString(lineContent[3], lines.length, i));
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    void printMonthlyReport() {
        for (int i = 1; i <= 3; i++) {
            monthlyReports.get(months[i-1]).printMonthlyReport();
            //System.out.println (monthlyReports.get(months[1]).isExpense[i]);
            //System.out.println (monthlyReports.get(months[1]).quantity[i]);
            //System.out.println (monthlyReports.get(months[1]).sumOfOne[i]);
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