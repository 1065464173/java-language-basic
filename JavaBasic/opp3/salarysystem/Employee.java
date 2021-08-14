/*
 * @Author: Sxuet
 * @Date: 2021-06-01 18:27:48
 * @LastEditTime: 2021-06-01 20:32:11
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/salarysystem/Employee.java
 * @Description: 
 */
package salarysystem;

public abstract class Employee {
    private String name;
    private int number;
    private myDate birthday;


    public Employee(String name, int number, myDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public abstract double earnings();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public myDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(myDate birthday) {
        this.birthday = birthday;
    }
    
    
    @Override
    public String toString() {
        return "{" +
            " name='" + name + "'" +
            ", number='" + number + "'" +
            ", birthday='" + birthday.toDateString() + "'" +
            "}";
    }
    
}
