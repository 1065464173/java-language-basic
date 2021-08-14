public class OperatorTest {
    public static void main(String[] args) {

        /* 计算有关运算符++&&的题目 */
        boolean x = true;
        boolean y = false;
        short z = 42;
        if(y==true) 
        if((z++==42)&&(y=true))z++;
        if((x==false)||(++z==45))z++;
        System.out.println(z);

        /* 交换两个数的位置 */
        int num1 = 10;
        int num2 = 20;
        //方法一( 推荐使用 )
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1="+num1);
        System.out.println("num2="+num2);
        //方法二 可能会溢出，只适用于数值运算
        num1 = num2 + num1 ;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("num1="+num1);
        System.out.println("num2="+num2);
        //方法三 位运算 只适用于数值运算
        num1 = num1^num2;
        num2 = num1^num2;
        num1 = num1^num2;
        System.out.println("num1="+num1);
        System.out.println("num2="+num2);

        /*三元运算符 比较三个数值大小 */
        int num3 = 2;
        int num4 = 10;
        int num5 = 9;
        num4 = 100;
        //不建议这么写，写着玩而已
        int maxNum = ((num3>num4)?((num3>num5)?num3:((num4>num5)?num4:num5)):((num4>num5)?num4:num5));
        System.out.println("maxNum="+maxNum);
    }
}
