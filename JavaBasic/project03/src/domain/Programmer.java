/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:10:00
 * @LastEditTime: 2021-06-07 15:53:28
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/domain/Programmer.java
 * @Description: 
 */

package domain;

public class Programmer extends Employee {
    private int memberId;
    private Status status;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary,Status status,Equipment equipment) {
        super(id, name, age, salary);
        this.status=status;
        this.equipment = equipment;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return this.equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString()+"\t程序员\t"+status+"\t\t\t"+equipment.getDescription();
    }
    public String getBaseDetailForTeam() {
        return getMemberId() +"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary();
    }
    public String getDetailForTeam() {
        return  getBaseDetailForTeam()+"\t"+"程序员";
    }
}
