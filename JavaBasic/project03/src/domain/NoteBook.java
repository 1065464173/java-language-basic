/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:11:52
 * @LastEditTime: 2021-06-05 18:10:29
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/domain/NoteBook.java
 * @Description: 
 */
package domain;

public class NoteBook implements Equipment {

    private String model;
    private double price;


    public NoteBook() {
        super();
    }
    
    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model+"("+price+")";
    }
    
}

