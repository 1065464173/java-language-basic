/*
 * @Author: Sxuet
 * @Date: 2021-05-25 18:57:06
 * @LastEditTime: 2021-05-26 19:01:12
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/polymorphism-gemetrics/GeometricTest.java
 * @Description: 
 */
/**
 * GeomotricTest
 */
public class GeometricTest {
    public static boolean equalsArea(GeometricObject o1,GeometricObject o2) {
        return o1.findArea()==o2.findArea();
    }
    public static void displayGeometricObject(GeometricObject o) {
        System.out.println("面积为："+o.findArea());
    }
    public static void main(String[] args) {
        GeometricObject go1 = new MyRectangle(1,"red",1, 1);
        GeometricObject go2 = new MyRectangle(1,"red",1, 1);
        GeometricObject go3 = new Circle(1, "blue", 2);
        displayGeometricObject(go1);
        System.out.println(go1.equals(go2));
        System.out.println(go1.equals(go3));
    }
}
