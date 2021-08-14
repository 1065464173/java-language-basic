/*
 * @Author: Sxuet
 * @Date: 2021-06-01 18:31:59
 * @LastEditTime: 2021-06-01 20:43:17
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/salarysystem/myDate.java
 * @Description: 
 */
package salarysystem;

public class myDate {
    private int year;
    private int month;
    private int day;


    public myDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
   

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    public String toDateString() {
        return year+"年"+month+"月"+day+"日";
    }
}
