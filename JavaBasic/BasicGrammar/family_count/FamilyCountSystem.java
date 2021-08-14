package family_count;

import java.util.Scanner;

/**
 * FamilyCount
 */
public class FamilyCountSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamilyCount fc = new FamilyCount();
        String details = fc.toString();
        boolean isFlag = true;
        do {
            System.out.println("**************家庭收支账单*************");
            System.out.println("              1,收支明细");
            System.out.println("              2,登记收入");
            System.out.println("              3,登记支出");
            System.out.println("              4,退出");
            System.out.print("              请选择(1-4):");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    System.out.println("请输入收入金额：");
                    fc.setIncome(scanner.nextInt());
                    System.out.println("请输入金额说明：");
                    fc.setInfo(scanner.next());
                    details+="\n"+fc.toString();
                    break;
                case 3:
                    System.out.println("请输入支出金额：");
                    fc.setSpending(scanner.nextInt());
                    System.out.println("请输入金额说明：");
                    fc.setInfo(scanner.next());
                    details+="\n"+fc.toString();
                    break;
                case 4:
                    isFlag = false;
                    break;

                default:
                    break;
            }
        } while (isFlag);
        scanner.close();
    }

}