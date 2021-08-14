/*
 ScaleExpression 
 进制表达 
 二进制：0、1，0b或者0B开头 
 八进制：0-7，0开头 
 十进制：0-9
 十六进制：0-9、A-F，0x或者0X开头
 */
public class ScaleExpression {
    public static void main(String[] args) {
        int num1 = 0b10;// 2
        int num2 = 025;// 8
        int num3 = 10;// 10
        int num4 = 0xAF;// 16

        System.out.println("num1 = "+num1);
        System.out.println("num2 = "+num2);
        System.out.println("num3 = "+num3);
        System.out.println("num4 = "+num4);
    }

}
