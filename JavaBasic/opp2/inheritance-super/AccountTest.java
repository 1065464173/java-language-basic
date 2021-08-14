/*
 * @Author: Sxuet
 * @Date: 2021-05-23 20:52:17
 * @LastEditTime: 2021-05-23 21:18:20
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/inheritance-super/AccountTest.java
 * @Description: 
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122,20000,0.045);
        account.withdraw(30000);
        System.out.println(account.getBalance());
        account.deposit(3000);
        System.out.println(account.getBalance());
        System.out.println(account.getMonthlyInterest());
    }
}
