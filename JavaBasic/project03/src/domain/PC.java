/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:11:46
 * @LastEditTime: 2021-06-05 18:09:36
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/domain/PC.java
 * @Description: 
 */
package domain;

public class PC implements Equipment{
    private String model;
    private String display;


    public PC() {
        super();
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    
    @Override
    public String getDescription() {
        return model+"("+display+")";
    }
    
}
