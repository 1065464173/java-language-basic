import java.util.Scanner;

/**
 * BranchTest
 */
public class BranchTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /* if-else */
        // 成绩奖励
        {
            int grade;
            System.out.println("请输入月小鹏的成绩");
            grade = scan.nextInt();
            if (grade == 100) {
                System.out.println("奖励一台BMW");
            } else if (grade > 80 && grade <= 99) {
                System.out.println("奖励一台IphoneX");

            } else if (grade >= 60 && grade <= 80) {
                System.out.println("奖励一个ipad");
            } else {
                System.out.println("啥也没有");
            }
        }

        // 随机彩票 符合且顺序一样10000元，符合顺序不一样3000元，符合一个顺序一样1000，符合一个顺序不一样500，一个没有无
        {// TODO: 彩票奖励的分支结构

            int lottery = (int) (Math.random() * 90 + 10);// [10,99]
            int num = scan.nextInt();
            System.out.println("lottery=" + lottery + ",your num=" + num);
        }

        /* switch-case */
        {
            // boolean flag = true;//Cannot switch on a value of type boolean. Only
            // convertible int values, strings or enum variables are permitted

            short s = 1;
            switch (s) {
                case 1:
                    System.out.println("haha");
                    break;
                case 2:
                    System.out.println("嘿诶");
                    break;
                case 3:
                    System.out.println("asd");
                    break;
                default:
                    break;
            }
        }
        // 输入月份天数，判断是当年的第几天
        {
            int month, day, year;
            // int feb;
            int sumDay = 0;
            System.out.println("请输入年份：");
            year = scan.nextInt();
            System.out.println("请输入" + year + "年的月份：");
            month = scan.nextInt();
            System.out.println("请输入" + month + "月的天数");
            day = scan.nextInt();

            /*
             * if ((year%4==0&&year%100!=0)||year%400==0) { feb=29;
             * System.out.println(year+"年是闰年"); } else { feb=28;
             * System.out.println(year+"年不是闰年"); }
             */
            switch (month) {
                case 12:
                    sumDay += 30;
                case 11:
                    sumDay += 31;
                case 10:
                    sumDay += 30;
                case 9:
                    sumDay += 31;
                case 8:
                    sumDay += 30;
                case 7:
                    sumDay += 31;
                case 6:
                    sumDay += 30;
                case 5:
                    sumDay += 31;
                case 4:
                    sumDay += 31;
                case 3:
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        sumDay += 29;
                        System.out.println(year + "年是闰年");
                    } else {
                        sumDay += 28;
                        System.out.println(year + "年不是闰年");
                    }
                case 2:
                    sumDay += 31;
                case 1:
                    sumDay += day;
                default:
                    break;
            }
            System.out.println(year + "年" + month + "月" + day + "日是" + year + "年的第" + sumDay + "天");
        }
        
        
        scan.close();

    }

}