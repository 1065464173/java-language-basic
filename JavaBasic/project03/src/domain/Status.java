/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:21:21
 * @LastEditTime: 2021-06-05 17:33:56
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/domain/Status.java
 * @Description: 
 */
package domain;

public class Status {
    private final String NAME;
    private Status(String name) {
        this.NAME = name;
    }
    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");
    public String getNAME() {
        return NAME;
    }
    @Override
    public String toString() {
        return NAME;
    }

}
