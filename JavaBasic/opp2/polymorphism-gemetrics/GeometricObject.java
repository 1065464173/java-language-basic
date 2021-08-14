import java.util.Objects;

/*
 * @Author: Sxuet
 * @Date: 2021-05-25 18:28:52
 * @LastEditTime: 2021-05-26 18:59:22
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/polymorphism-gemetrics/GeometricObject.java
 * @Description: 
 */
/**
 * GeometricObject
 */
public class GeometricObject {
    private String color;
    private double weight;

    GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "{" + " color='" + getColor() + "'" + ", weight='" + getWeight() + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GeometricObject)) {
            return false;
        }
        GeometricObject geometricObject = (GeometricObject) o;
        return Objects.equals(color, geometricObject.color) && weight == geometricObject.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, weight);
    }


}
