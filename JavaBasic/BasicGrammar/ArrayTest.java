import java.util.Arrays;

/*
 * @Author: Sxuet
 * @Date: 2021-05-15 16:17:58
 * @LastEditTime: 2021-05-16 15:16:11
 * @LastEditors: Sxuet
 * @FilePath: /Javasource_SGG/BasicGrammar/ArrayTest.java
 * @Description: 
 */
public class ArrayTest {
    public static void main(String[] args) {
        /* 一维数组默认初始化值 */
        {
            // int[] nums = new int[5];//0
            // double[] nums = new double[5];//0.0
            // char[] nums = new char[5];//0|'/u0000'
            // boolean[] nums = new boolean[5];//false

            String[] nums = new String[5];// null 不是 “null”
            System.out.println("一维数组的遍历：");
            for (String i : nums) {
                System.out.print(i + " ");
            }
            System.out.println();

        }
        /* 二维数组 */
        {
            // 静态初始化
            int[][] nums1 = new int[][] { { 1, 2, 3 }, { 1, 2 }, { 2 } };
            // 动态初始化
            int[][] nums2 = new int[5][];
            nums2[1] = new int[1];
            // int[][] nums3 = new int[5][2];
            // int[] nums4[] = new int[1][1];
            // int nums5[][] = new int[1][1];

            // 遍历二维数组
            System.out.println("二维数组的遍历：");
            for (int i = 0; i < nums1.length; i++) {
                System.out.println("外层元素：" + nums1[i]);
                for (int j = 0; j < nums1[i].length; j++) {
                    System.out.print(nums1[i][j] + " ");
                }
                System.out.println();

            }

        }
        /* 杨辉三角 */
        {
            System.out.println("杨辉三角：");
            int[][] yh = new int[10][];

            for (int i = 0; i < yh.length; i++) {
                yh[i] = new int[i + 1];
                yh[i][0] = yh[i][i] = 1;
                for (int j = 1; j < yh[i].length - 1; j++) {
                    yh[i][j] = yh[i - 1][j - 1] + yh[i - 1][j];
                    // if (j==0) {
                    // yh[i][j]=1;
                    // } else if(j==yh[i].length-1){
                    // yh[i][j]=1;
                    // }else{
                    // yh[i][j]=yh[i-1][j-1]+yh[i-1][j];
                    // }
                }
            }

            // 遍历
            for (int i = 0; i < yh.length; i++) {
                for (int j = 0; j < yh[i].length; j++) {
                    System.out.print(yh[i][j] + "\t");
                }
                System.out.println();
            }
        }
        /* 数组的复制 */
        {
            System.out.println("数组的复制：");
            int[] arr1 = new int[] { 2, 3, 5, 7, 11, 17, 19 };
            int[] arr2 = new int[arr1.length];
            System.out.print("arr1:");
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(arr1[i] + " ");
            }
            System.out.print("\narr2:");
            for (int i = 0; i < arr1.length; i++) {
                if (i % 2 == 0) {
                    arr2[i] = i;
                } else {
                    arr2[i] = arr1[i];
                }
                System.out.print(arr2[i] + " ");
            }
            System.out.println();
            // System.out.println("\narr2length:"+arr2.length);

        }
        /* 数组的反转 */
        {
            System.out.println("数组的反转：");
            int[] arr = new int[] { 1, 2, 3, 4, 5 };
            for (int i = 0; i < arr.length / 2; i++) {
                arr[i] = arr[i] ^ arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = arr[i] ^ arr[arr.length - 1 - i];
                arr[i] = arr[i] ^ arr[arr.length - 1 - i];
            }
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
        }
        /* 查找 */
        {
            // 顺序查找
            System.out.println("顺序查找：");
            String[] sarr = new String[] { "AA", "BB", "CC", "DD", "FF" };
            String s = "AA";
            boolean isflag = true;
            for (int i = 0; i < sarr.length; i++) {
                if (s == sarr[i]) {
                    System.out.println("找到了！为数组的第" + (i + 1) + "个元素");
                    isflag = false;
                    break;
                }
            }
            if (isflag) {
                System.out.println("没有找到。。");
            }

            // 二分法查找：折半查找 前提有序
            System.out.println("二分法查找：");
            int[] arr = new int[] { 1, 2, 3, 4, 5 };
            int dest = 26;
            int head = 0;
            int end = arr.length - 1;
            boolean isflag1 = true;
            while (head <= end) {
                int middle = (head + end) / 2;
                if (dest == arr[middle]) {
                    isflag1 = false;
                    System.out.println("找到了！为数组的第" + (middle+1) + "个元素");
                    break;
                } else if (dest < arr[middle]) {
                    end = middle - 1;
                } else {
                    head = middle + 1;
                }
            }
            if (isflag1) {
                System.out.println("很遗憾没有找到");
            }
        }
        /*ARRAYS工具类 */
        {
            //equals
            int[] arr1 = new int[]{1,2,3};
            int[] arr2 = new int[]{1,2,3};
            System.out.println(Arrays.equals(arr1,arr2));
            Arrays.fill(arr1, 10);
            Arrays.sort(arr2);
            System.out.println(Arrays.binarySearch(arr2, 3));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(arr1));
        
        }
    }
}
