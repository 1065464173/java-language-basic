import static org.junit.jupiter.api.DynamicTest.stream;

/*
 * @Author: Sxuet
 * @Date: 2021-06-01 14:53:29
 * @LastEditTime: 2021-06-01 14:59:18
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp3/TemplateTest.java
 * @Description: 
 */
public class TemplateTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d.spendingTime());
    }
}

abstract class TemplateSpending {
    public abstract void code();

    public long spendingTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return end - start;
    }
}

class Dog extends TemplateSpending {

    @Override
    public void code() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("wow!");
        }
    }

}