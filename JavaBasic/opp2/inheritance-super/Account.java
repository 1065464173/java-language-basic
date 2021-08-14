/*
 * @Author: Sxuet
 * @Date: 2021-05-23 20:45:49
 * @LastEditTime: 2021-05-23 22:20:52
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/inheritance-super/Account.java
 * @Description: 
 */
public class Account {
    //编号
    private int id;
    //余额
    protected double balance;
    //年利率
    private double annualInterestRate;

    public Account() {
        this(0,0,0);
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    /**
     * @description: 获取月利率
     * @Author: Sxuet
     * @Date: 2021-05-23 20:51:04
     * @param {*}
     * @return double：annualInterestRate/12
     */
    public double getMonthlyInterest() {
        return annualInterestRate/12;
    }
    /**
     * @description: 取钱
     * @Author: Sxuet
     * @Date: 2021-05-23 20:50:52
     * @param {double} amount
     * @return {*}
     */
    public void withdraw(double amount) {
        if (amount<=balance) {
            balance-=amount;
            return;
        }
        System.out.println("余额不足");
    }
    /**
     * @description: 存钱
     * @Author: Sxuet
     * @Date: 2021-05-23 20:51:49
     * @param {double} amount
     * @return {*}
     */
    public void deposit(double amount) {
        if (amount>0) {
            balance+=amount;
        }
    }
}
