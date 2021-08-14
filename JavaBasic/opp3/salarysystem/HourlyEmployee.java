/*
 * @Author: Sxuet
 * @Date: 2021-06-01 20:32:58
 * @LastEditTime: 2021-06-01 20:47:29
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/salarysystem/HourlyEmployee.java
 * @Description: 
 */
package salarysystem;

public class HourlyEmployee extends Employee {
    private int wage;
    private int hour;

    public HourlyEmployee(String name, int number, myDate birthday) {
        super(name, number, birthday);
    }
    public HourlyEmployee(String name, int number, myDate birthday,int wage,int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee"+super.toString();
    }
}
