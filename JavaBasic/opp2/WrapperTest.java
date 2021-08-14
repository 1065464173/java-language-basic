import org.junit.Test;

/*
 * @Author: Sxuet
 * @Date: 2021-05-26 20:57:33
 * @LastEditTime: 2021-05-30 16:59:57
 * @LastEditors: Sxuet
 * @FilePath: /JavaSE_learning/Javasource_SGG/opp2/WrapperTest.java
 * @Description: 
 */
public class WrapperTest {
    @Test
    public void test() {
        int num1 = 10;
        Integer in1 = num1;
        System.out.println(in1.toString());

        // boolean b;// 初始化false
        // Boolean B;// 初始化null

        //string->int/intager
        String s = "123";
        int a = Integer.parseInt(s);
        System.out.println(a);

        //int/integer->string
        a++;
        // System.out.println(s.valueOf(a));

        //string->boolean
        String ss= "true123";
        Boolean boolean1 = Boolean.parseBoolean(ss);
        System.out.println(boolean1);

    }
    /**
     * @description: 面试题测试
     * @Author: Sxuet
     * @Date: 2021-05-26 22:07:47
     * @param {*}
     * @return {*}
     */
    @Test
    public void interviewQ1() {
        //三元运算符后面两个类型要归为一致，所以ineger->double 
        // Object object = true?new Integer(1):new Double(2.0);
        // System.out.println(object);//1.0
    }

    @Test
    public void interviewQ2() {

        //Integer cache[] -128～127

        // Integer a = new Integer(1);
        // Integer b = new Integer(1);
        // System.out.println(a==b);//false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m==n);//true

        Integer x = 128;//相当于new了一个Integer对象
        Integer y = 128;
        System.out.println(x==y);//false


    }
}
