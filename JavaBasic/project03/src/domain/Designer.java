/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:10:14
 * @LastEditTime: 2021-06-07 15:38:33
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/domain/Designer.java
 * @Description: 
 */
package domain;

public class Designer extends Programmer {

    

    private double bonus;

    public double getBonus() {
        return this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public Designer(int id, String name, int age, double salary,Status status, Equipment equipment,double bonus) {
        super(id, name, age, salary, status,equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails()+"\t设计师\t"+getStatus()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
    }
    public String getDetailForTeam() {
        return getBaseDetailForTeam()+"\t设计师"+"\t"+getBonus()+"\t";
    }
    
}
