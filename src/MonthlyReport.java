public class MonthlyReport {
    private String [] itemName;
    private boolean [] isExpense;
    private Integer [] quantity;
    private Integer [] sumOfOne;
    private int i;
    ///////////////////////////
    private int monthlyExpenses;
    private int monthlyIncome;
    private int categoryOfMaxMonthlyExpenses;
    private int categoryOfMaxMonthlyIncome;

    MonthlyReport (int numberOfEntries){
        itemName=new String[numberOfEntries];
        isExpense=new boolean[numberOfEntries];
        quantity=new Integer[numberOfEntries];
        sumOfOne=new Integer[numberOfEntries];
        i=0;
        ///////////////////////
        monthlyExpenses=0;
        monthlyIncome=0;
        categoryOfMaxMonthlyExpenses=-1;
        categoryOfMaxMonthlyIncome=-1;
    }
    ////////////////////////////////////////////////////////////////////////////////
    void setMonthlyReport(String itemName, boolean isExpense, int quantity, int sumOfOne){
        this.itemName[i]=itemName;
        this.isExpense[i]=isExpense;
        this.quantity[i]=quantity;
        this.sumOfOne[i]=sumOfOne;
        i++;
    }
    /////////////////////////////////////////////////////////////////////////////////
    void setExAndInAndMaxOfMonth() {
        int maxMonthlyExpenses=0;
        int maxMonthlyIncome=0;
        for (int i=0; i<itemName.length;i++ ){
            int sum=quantity[i]*sumOfOne[i];
            if (isExpense[i]){
                this.monthlyExpenses+=sum;
                if (sum>maxMonthlyExpenses){
                    maxMonthlyExpenses=sum;
                    this.categoryOfMaxMonthlyExpenses=i;
                }
            }else{
                this.monthlyIncome+=sum;
                if (sum>maxMonthlyIncome) {
                    maxMonthlyIncome=sum;
                    this.categoryOfMaxMonthlyIncome=i;
                }
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////////////
    String getItemName (int i){
        return itemName [i];
    }
    /////////////////////////////////////////////////////////////////////////////////
    boolean getIsExpense (int i) {
        return isExpense[i];
    }
    /////////////////////////////////////////////////////////////////////////////////
    Integer getQuantity (int i) {
        return quantity[i];
    }
    /////////////////////////////////////////////////////////////////////////////////
    Integer getSumOfOne (int i){
        return sumOfOne[i];
    }
    ////////////////////////////////////////////////////////////////////////////////
    int getMonthlyExpenses (){
        return monthlyExpenses;
    }
    //////////////////////////////////////////////////////////////////////////////////
    int getMonthlyIncome() {
        return monthlyIncome;
    }
    //////////////////////////////////////////////////////////////////////////////////
    int getCategoryOfMaxMonthlyExpenses() {
        return categoryOfMaxMonthlyExpenses;
    }
    //////////////////////////////////////////////////////////////////////////////////
    int getCategoryOfMaxMonthlyIncome() {
        return categoryOfMaxMonthlyIncome;
    }
}

