package com.jinfeng.spark.util;


import com.jinfeng.spark.sort.*;

/**
 * Project : Spark
 * Package : com.jinfeng.spark.sort
 * Author : WangJinfeng
 * Date : 2017-10-29 12:27
 * Email : wangjinfeng@yiche.com
 * Phone : 152-1062-7698
 */

public class SortAlgo {

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        System.out.print("排序前：");
        printArr(numbers);

        //  BubbleSort.bubbleSort(numbers);
        //  System.out.print("冒泡排序后：");
        //  printArr(numbers);

        //  QuickSort.quick(numbers);
        //  System.out.print("快速排序后：");
        //  printArr(numbers);

        //  InsertSort.insertSort(numbers);
        //  System.out.print("插入排序后：");
        //  printArr(numbers);

        //  ShellSort.shellSort(numbers);
        //  System.out.print("希尔排序后：");
        //  printArr(numbers);

        //  MergeSort.mergeSort(numbers);
        //  System.out.print("归并排序后：");
        //  printArr(numbers);

        //  HeapSort.heapSort(numbers);
        //  System.out.print("堆排序后：");
        //  printArr(numbers);

        SelectSort.selectSort(numbers);
        System.out.print("选择排序后：");
        printArr(numbers);
    }
}
