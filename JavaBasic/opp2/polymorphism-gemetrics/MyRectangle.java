import java.util.Objects;

/*
 * @Author: Sxuet
 * @Date: 2021-05-25 18:53:13
 * @LastEditTime: 2021-05-26 18:59:37
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/polymorphism-gemetrics/MyRectangle.java
 * @Description: 
 */
public class MyRectangle extends GeometricObject {
    private double weight;
    private double height;

    MyRectangle(double width, String color, double height, double weight) {
        super(color, width);
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double findArea() {
        return height * weight;
    }

    @Override
    public String toString() {
        return "{" + " weight='" + getWeight() + "'" + ", height='" + getHeight() + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MyRectangle)) {
            return false;
        }
        MyRectangle myRectangle = (MyRectangle) o;
        return weight == myRectangle.weight && height == myRectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, height);
    }


}
