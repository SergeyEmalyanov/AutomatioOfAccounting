import java.util.Scanner;
public class AutomationOfAccounting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportsApp reportsApp=new ReportsApp();
        while (true) {
            printMenu();
            String userInput = scanner.next();
            if (inputExceptions(userInput, 5)) {
                if (userInput.equals("выход")) {
                    System.out.println("6");
                    break;
                } else if (parseUserInput(userInput) == 1) {
                    reportsApp.readAndSaveMonthlyReports();
                } else if (parseUserInput(userInput) == 2) {
                    System.out.println("2");
                } else if (parseUserInput(userInput) == 3) {
                    System.out.println("3");
                } else if (parseUserInput(userInput) == 4) {
                    reportsApp.printMonthlyReport();
                } else if (parseUserInput(userInput) == 5) {
                    System.out.println("5");
                }
            } else {
                System.out.println("Нет такой команды");
            }
        }
    }

    /////////////////////////////////////////////////////////////////////
    public static void printMenu() {
        System.out.println("1.Считать все месячные отчёты");
        System.out.println("2.Считать годовой отчёт");
        System.out.println("3.Сверить отчёты");
        System.out.println("4.Вывести информацию о всех месячных тратах");
        System.out.println("5.Вывести информацию о годовом отчёте");
        System.out.println("выход.Выход");

    }
    /////////////////////////////////////////////////////////////////////
    public static int parseUserInput(String userInput) {
        return (Integer.parseInt(userInput));
    }
    /////////////////////////////////////////////////////////////////////
    public static boolean inputExceptions(String userInput, int menuItems) {
        boolean a = false;
        for (int i = 1; i <= menuItems; i++) {
            a = a || userInput.equals(Integer.toString(i));
        }
        a = a || userInput.equals("выход");
        return (a);
    }
}