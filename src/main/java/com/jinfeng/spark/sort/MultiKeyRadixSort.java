package com.jinfeng.spark.sort;

import java.util.Arrays;

/**
 * Project : Spark
 * Package : com.jinfeng.spark.sort
 * Author : WangJinfeng
 * Date : 2017-11-11 12:31
 * Email : wangjinfeng@yiche.com
 * Phone : 152-1062-7698
 * <p>
 * 基数排序的总体思路：
 * 将待排序数据拆分成多个关键字进行排序，实质是关键字的排序
 * 多关键字排序时两种解决方案：
 * 最高位优先法(MSD)(Most Significant Digit first)
 * 最低位优先法(LSD)(Least Significant Digit first)
 * 稳定排序算法
 */
public class MultiKeyRadixSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{1100, 192, 221, 12, 23};
        print(numbers);
        radixSort(numbers, 10, 4);
        System.out.println("排序后的数组：");
        print(numbers);
    }

    public static void radixSort(int[] numbers, int radix, int d) {
        //  缓存数组
        int[] temp = new int[numbers.length];

        //  buckets用于记录待排序元素的信息，buckets数组定义了max-min个桶
        int[] buckets = new int[radix];

        for (int i = 0, rate = 1; i < d; i++) {
            //  重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            //  将numbers中的元素完全复制到temp数组中
            System.arraycopy(numbers, 0, temp, 0, numbers.length);

            //  计算每个待排序数据的子关键字
            for (int j = 0; j < numbers.length; j++) {
                int subKey = (temp[j] / rate) % radix;
                buckets[subKey]++;
            }

            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            //  按子关键字对指定的数据进行排序
            for (int m = numbers.length - 1; m >= 0; m--) {
                int subKey = (temp[m] / rate) % radix;
                numbers[--buckets[subKey]] = temp[m];
            }
            rate *= radix;
        }
    }

    public static void print(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println();
    }
}
