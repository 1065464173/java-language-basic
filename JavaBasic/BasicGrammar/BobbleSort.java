/*
 * @Author: Sxuet
 * @Date: 2021-05-16 10:30:25
 * @LastEditTime: 2021-05-16 11:19:33
 * @LastEditors: Sxuet
 * @FilePath: /Javasource_SGG/BasicGrammar/BobbleSort.java
 * @Description: 
 */
/**
 * BobbleSort
 */
public class BobbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{34,12,42,567,23,83,236,32,69,4};
        
        //排序
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        //打印
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
}