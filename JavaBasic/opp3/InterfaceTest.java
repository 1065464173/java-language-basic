
/*
 * @Author: Sxuet
 * @Date: 2021-06-02 16:47:13
 * @LastEditTime: 2021-06-02 17:02:51
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/InterfaceTest.java
 * @Description: 
 */
public class InterfaceTest {
    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.method1();//类优先原则
    }

}

interface CompareA {
    //可以被实例类直接调用，或者重写
    default void method1() {
        System.out.println("CompareA:method1");
    }

    public static void method2() {
        System.out.println("CompareA:method2");
    }

    //可以直接被调用不可以被重写
    default void method3() {
        System.err.println("CompareA:method3");
    }
}

interface CompareB {
    default void method1() {
        System.out.println("CompareB:method1");
    }

    default void method2() {
        System.out.println("CompareB:method2");
    }

    default void method3() {
        System.out.println("CompareB:method3");
    }
}

class SuperClass implements CompareA,CompareB {
    //重写
    public void method1(){
        System.out.println("super1");
    }

    //接口冲突——覆盖操作
    public  void method3(){
        System.out.println("super3");
    }
}

class SubClass extends SuperClass{
    
}