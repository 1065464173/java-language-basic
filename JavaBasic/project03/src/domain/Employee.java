/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:09:32
 * @LastEditTime: 2021-06-05 22:35:01
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/domain/Employee.java
 * @Description: 
 */
package domain;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;


    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDetails() {
        return id+"\t"+name+"\t"+age+"\t"+salary;
        
    }
    @Override
    public String toString() {
        return id+"\t"+name+"\t"+age+"\t"+salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && age == employee.age && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, salary);
    }
    
    

}
