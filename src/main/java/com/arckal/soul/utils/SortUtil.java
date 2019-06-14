package com.arckal.soul.utils;

/**
 * @Author: arckal
 * @Date: 2019/4/29 15:33
 * @Version 1.0
 */
public class SortUtil {

    public static void main(String[] args){
        System.out.println("start...");
        int[] arr = {5,18,27,33,42,66,90,8,81,47,13,67,9,36,62,22};
        bucketSort(arr);
        for (int i:arr) {
            System.out.print(i + ", ");
        }

    }

    public static void bucketSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        //常用写法
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }

        int[] bucket = new int[max+1];

        for (int i=0;i<arr.length;i++){
            // 桶数组此下标有数据，数值就加一
            bucket[arr[i]]++;
        }

        int i=0;
        for (int j=0; j<bucket.length;j++){
            while(bucket[j]-->0){
                arr[i++]=j;
            }
        }
    }
}
