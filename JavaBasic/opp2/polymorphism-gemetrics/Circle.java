import java.util.Objects;

/*
 * @Author: Sxuet
 * @Date: 2021-05-25 18:44:21
 * @LastEditTime: 2021-05-26 20:47:53
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/polymorphism-gemetrics/Circle.java
 * @Description: 
 */
public class Circle extends GeometricObject {
    private double radius;
    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "{" + " radius='" + getRadius() + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Circle)) {
            return false;
        }
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }


}
