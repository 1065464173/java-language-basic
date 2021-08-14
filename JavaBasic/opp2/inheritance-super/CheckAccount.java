/*
 * @Author: Sxuet
 * @Date: 2021-05-23 21:18:55
 * @LastEditTime: 2021-05-23 22:21:05
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/inheritance-super/CheckAccount.java
 * @Description: 
 */
public class CheckAccount extends Account {
    private double overdraft;//可透支金额
    
    public CheckAccount(){
        this(0,0,0,0);
    }

    public CheckAccount(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount<balance) {
            //取款
        }else if(amount>balance){
            double overAmount = amount - balance;
            if (overdraft>overAmount) {
                overdraft-=overAmount;
                setBalance(0);
            } else {
                System.out.println("可透支的金额"+overdraft+"元不足以支付！");
            }
        }
    }
}

