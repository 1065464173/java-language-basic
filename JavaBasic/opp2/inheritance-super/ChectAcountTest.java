/*
 * @Author: Sxuet
 * @Date: 2021-05-23 22:15:22
 * @LastEditTime: 2021-05-23 22:20:07
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/inheritance-super/ChectAcountTest.java
 * @Description: 
 */
public class ChectAcountTest {
   public static void main(String[] args) {
       CheckAccount cAccount = new CheckAccount(1122, 10000, 0.045, 10000);
       cAccount.withdraw(15000);
       System.out.println(cAccount.getBalance());
       System.out.println(cAccount.getOverdraft());
   } 
}
