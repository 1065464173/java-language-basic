/*
 * @Author: Sxuet
 * @Date: 2021-06-01 14:36:53
 * @LastEditTime: 2021-06-01 14:53:17
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/AbstractTest.java
 * @Description: 
 */
public class AbstractTest {
    public static void main(String[] args) {
        show(new Person(){

            @Override
            public void eat() {
                System.out.println("eateat!");                
            }
            
        });
    }
    public static void show(Person p ) {
        p.eat();
    }
    
}
abstract class Person{
    public int age;
    public abstract void eat();
}
class student extends Person{

    @Override
    public void eat() {
        System.out.println("student eat");        
    }
}