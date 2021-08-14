/*
 * @Author: Sxuet
 * @Date: 2021-06-01 20:28:57
 * @LastEditTime: 2021-06-01 20:45:21
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/salarysystem/SalariedEmployee.java
 * @Description: 
 * 
 */
package salarysystem;

public class SalariedEmployee extends Employee {
    private int monthlySalary;

    public SalariedEmployee(String name, int number, myDate birthday) {
        super(name, number, birthday);
    }

    public SalariedEmployee(String name, int number, myDate birthday,int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }



    public int getMonthlySalary() {
        return this.monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    
    @Override
    public double earnings() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee"+super.toString();
    }
    

}
