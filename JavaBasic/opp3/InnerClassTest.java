/*
 * @Author: Sxuet
 * @Date: 2021-06-02 17:22:45
 * @LastEditTime: 2021-06-02 21:39:13
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/InnerClassTest.java
 * @Description: 
 */
public class InnerClassTest {
    public static void main(String[] args) {
        /*成员内部类实例化 */
        //创建静态内部类实例——直接通过外部类.内部类名创建
        Human.Body body = new Human.Body(); 
        body.show();
        //创建非静态内部类实例——需要通过外部类的实例.内部类名创建
        Human human  = new Human();
        Human.Brain brain =human.new Brain();
        brain.name("name");
        
    }
    /*局部内部类 */
    //情况一：开发中较少用
    public static void method() {
        class AA{

        }
    }
    //情况二：开发中较常用
    //返回一个Comparable接口的实现类。在内部实现的原因是外部不使用
    public static Comparable myComparable(){
        //局部内部类
        // 方式一
        // class MyComparable implements Comparable{

        //     @Override
        //     public int compareTo(Object o) {
        //         return 0;
        //     }

        // }
        // return new MyComparable();

        //方式二
        return new Comparable(){

            @Override
            public int compareTo(Object o) {
                return 0;
            }
            
        };
    }
}

class Human{
    String name;
    int age;
    //非静态成员内部类
    class Brain{
        String name;
        int IQ;
        //调用外部类的（同名/不同名）参数
        public void name(String name) {
            System.out.println(name);//形参
            System.out.println(this.name);//内部类的属性
            System.out.println(Human.this.name);//外部类的属性
        }
    }
    //静态成员内部类
    static class Body{
        String color;
        public void show() {
            System.out.println("body");
        }
    }
}
