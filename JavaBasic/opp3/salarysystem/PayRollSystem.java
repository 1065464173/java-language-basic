/*
 * @Author: Sxuet
 * @Date: 2021-06-01 20:39:57
 * @LastEditTime: 2021-06-01 20:52:12
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/salarysystem/PayRollSystem.java
 * @Description: 
 */
package salarysystem;

import java.util.Calendar;

public class PayRollSystem {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.MONTH;

        Employee[] employees = new Employee[2];
        employees[0] = new SalariedEmployee("小米", 1001, new myDate(1999,2,3),10000);
        employees[1] = new HourlyEmployee("小哦", 1002, new myDate(1999,2,3),60,100);
        for (Employee employee : employees) {
            System.out.println(employee);
            double salary = employee.earnings();
            System.out.println("月工资为"+salary+"元");
            if (month+1 == employee.getBirthday().getMonth()) {
                System.out.println("生日快乐");
            }
        }
    }
    
}
