/*
 * @Author: Sxuet
 * @Date: 2021-05-17 18:44:05
 * @LastEditTime: 2021-05-17 19:57:22
 * @LastEditors: Sxuet
 * @FilePath: /Javasource_SGG/oop/RecursionTest.java
 * @Description: 
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(getSum(5));
        System.out.println(getSum1(5));
        System.out.println(getSum2(5));
        hanio(2, 'a', 'b', 'c');
    }

    // 求1-n的合
    public static int getSum(int n) {
        if (n == 1)
            return 1;
        else
            return n + getSum(n - 1);
    }

    // 求n！
    public static int getSum1(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getSum1(n - 1);
        }
    }

    // f(n+2)=2*f(n+1)+f(n),n 为大于0 的整数
    public static int getSum2(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 4;
        } else {
            return 2 * getSum2(n - 1) + getSum2(n - 2);
        }
    }
    /*汉诺塔问题
        n 盘子
        a 起始柱子
        b 借助柱子
        c 目标柱子
    */
    
    public static void hanio(int n ,char a,char b,char c) {
        if (n==1) {
            move(n, a, c);
        }else{
            //三步曲，注意观察，a,b,c三个的位置变化
            //1.把 n-1 个盘子看成一个整体，借助 C 从 A 移动到 B
            hanio(n-1,a,c,b);
            //2.把第 n 个盘子从 A 移动到 C
            move(n,a,c);
            //3.再把 n-1 盘子整体，借助 A 从 B 移动到 C
            hanio(n-1,b,a,c);
        }
    }
    public static void move(int n, char x,char y) {
        System.out.println("把第"+n+"个盘子从"+x+"柱子上移到"+y+"柱子上");
    }
    //斐波纳列数列
    
    //快排

}
