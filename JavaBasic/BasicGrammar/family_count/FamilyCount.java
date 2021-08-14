package family_count;

public class FamilyCount {
    FamilyCount(){
        this(0, 0, 0, "");
    }
    FamilyCount(int balance,int income,int spending,String info){
        this.balance=balance;
        this.income=income;
        this.info=info;
        this.spending=spending;
    }
    private int balance;
    private String info;
    private int income;
    private int spending;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
        this.balance+=income;
    }

    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
        this.balance-=spending;
    }

    @Override
    public String toString() {
        return "FamilyCount [balance=" + balance + ", income=" + income + ", spending=" + spending + ", info=" + info
                + "]";
    }

}
