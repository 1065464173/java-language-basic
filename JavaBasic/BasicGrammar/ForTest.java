import java.util.Scanner;

/**
 * ForTest
 */
public class ForTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /* 求两个数的最大公约数和最小公倍数 */
        {
            int num1, num2;
            System.out.println("请输入第一个正整数：");
            num1 = scan.nextInt();
            System.out.println("请输入第二个正整数：");
            num2 = scan.nextInt();
            int min = (num1 >= num2) ? num2 : num1;
            // 最小公约数
            for (int i = min; i > 1; i--) {
                if (num1 % i == 0 && num2 % i == 0) {
                    System.out.println("最大公约数：" + i);
                    break;
                }
            }
            // 最大公倍数
            int max = (num1 > num2) ? num1 : num2;
            for (int i = max; i < num1 * num2; i++) {
                if (i % num1 == 0 && i % num2 == 0) {
                    System.out.println("最小公倍数：" + i);
                    break;
                }
            }
        }

        /* 九九乘法表 */
        {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
                }
                System.out.println();
            }
        }

        /* 100以内所有的质数：只能被1和自身整除 */
        // 2～（n-1）都不能被n整除
        {
            // boolean flag = true;
            int count =0;
            long start = System.currentTimeMillis(); // 开始
            label:for (int i = 2; i <= 100000; i++) {// 100以内的自然数
                // for (int j = 2; j < i; j++) {
                for (int j = 2; j < Math.sqrt(i); j++) {//优化2
                    if (i % j == 0) {
                        // flag = false;
                        // break;// 优化1
                        continue label;
                    }
                }
                count++;//能执行到此步骤的都是质数
                // if (flag == true) {
                //     System.out.print(i + " ");
                //     count++;
                // }
                // flag = true;
            }
            System.out.println("质数的总数为："+count);
            long end = System.currentTimeMillis(); // 结束
            System.out.println("运行时间" + (end - start) + "ms"); // 无break：3468ms ；break：505ms ; math.sqrt:13ms
        }

        /*break and continue */
        {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j%4==0) {
                        break;
                    }
                    System.out.println(j);
                }
            }
        }
        scan.close();

    }
}
