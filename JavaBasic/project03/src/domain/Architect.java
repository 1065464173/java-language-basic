/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:10:48
 * @LastEditTime: 2021-06-07 15:38:10
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/domain/Architect.java
 * @Description: 
 */
package domain;

public class Architect extends Designer {

    

    private int stock;

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Status status,Equipment equipment, double bonus,int stock) {
        super(id, name, age, salary, status,equipment, bonus);
        this.stock = stock;
    }


    @Override
    public String toString() {
        return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+getStock()+"\t"+getEquipment().getDescription();
    }
    public String getDetailForTeam() {
        return getBaseDetailForTeam()+"\t"+"架构师"+"\t"+getBonus()+"\t"+getStock();
    }
}

