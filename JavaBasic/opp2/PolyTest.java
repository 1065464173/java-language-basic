/*
 * @Author: Sxuet
 * @Date: 2021-05-25 19:13:43
 * @LastEditTime: 2021-05-26 18:57:39
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/PolyTest.java
 * @Description: 
 */
public class PolyTest {
    public static void main(String[] args) {
        Base b = new Sub();
        b.add(1, 2, 3);//sub1
        Sub s = (Sub) b;
        s.add(1, 2, 3);//sub2 执行自己的方法
    }
}

class Base {
    public void add(int a, int... arr) {
        System.out.println("Base");
    }
}

class Sub extends Base {
    public void add(int a,int... arr){//public void add(int a, int[] arr) { // 重写public void add(int a, int... arr) 
        System.out.println("Sub1");
    }

    public void add(int a, int b, int c) {
        System.out.println("Sub2");
    }
}