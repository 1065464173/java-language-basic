/*
 * @Author: Sxuet
 * @Date: 2021-05-16 13:47:21
 * @LastEditTime: 2021-05-16 14:49:16
 * @LastEditors: Sxuet
 * @FilePath: /Javasource_SGG/BasicGrammar/QuickSort.java
 * @Description: 
 */
public class QuickSort {
    public static void swap(int[] arr,int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]=temp;
    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex>rightIndex){
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[left];
        //降序，左右交替扫描，直到left=right
        while (left < right) {
            while (arr[right] <= key && left < right) {
                right--; //找到比key大的值
            }
            while (arr[left] >= key && left < right) {
                left++; //找到比key小的值
            }
            if (left<right) {
                //大值放左边，小放右，交换位置
                swap(arr, left, right);
            }
                
        }
        swap(arr,right,leftIndex);
        //递归左函数
        quickSort(arr, leftIndex, left - 1);
        //递归右函数
        quickSort(arr, right + 1, rightIndex);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 51, 7, 9, 7, 10, 34, 53, 237, 43 };
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        System.out.println("排序前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("排序后：");
        quickSort(arr, leftIndex, rightIndex);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(+arr[i]+" ");
        }
    }
}
