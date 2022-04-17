public class YearlyReport {
    int [] months;
    int [] amount;
    boolean [] isExpense;
    YearlyReport (int numberOfEntries) {
        months=new int [numberOfEntries];
        amount=new int[numberOfEntries];
        isExpense =new boolean[numberOfEntries];
    }

}
