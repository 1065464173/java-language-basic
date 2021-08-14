/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:11:57
 * @LastEditTime: 2021-06-05 18:11:00
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/domain/Printer.java
 * @Description: 
 */
package domain;

public class Printer implements Equipment{
    private String name;
    private String type;


    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name+"("+type+")";
    }
    
}
