public class MonthlyReport {
    String [] itemName;
    boolean [] isExpense;
    Integer [] quantity;
    Integer [] sumOfOne;
    MonthlyReport (int numberOfEntries){
        itemName=new String[numberOfEntries];
        isExpense=new boolean[numberOfEntries];
        quantity=new Integer[numberOfEntries];
        sumOfOne=new Integer[numberOfEntries];
    }
    void printMonthlyReport () {
        for (int i=0; i<itemName.length; i++) {
            System.out.println (itemName[i]);
        }
    }
}
