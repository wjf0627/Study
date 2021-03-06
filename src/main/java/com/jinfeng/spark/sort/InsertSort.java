package com.jinfeng.spark.sort;

/**
 * Project : Spark
 * Package : com.jinfeng.spark.sort
 * Author : WangJinfeng
 * Date : 2017-10-30 21:36
 * Email : jinfeng.wang@yoyi.com.cn
 * Phone : 152-1062-7698
 *
 * 时间复杂度：O(n^2)
 */
public class InsertSort {
    /**
     * 基本思想：在要排序的一组数中，假设前面（n-1）[n>=2]个数已经是排好顺序的，
     * 现在要把n个数查到前面的有序数中，使得这n个数也是排好顺序的，如此反复循环
     * 直到全部排好顺序
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排好序
     * 取出第一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     *
     * 时间复杂度为：
     *      平均：O(n^2)
     *      最好：O(n)
     *      最坏：O(n^2)
     * 不稳定排序
     * @param numbers
     */
    public static void insertSort(int[] numbers) {
        int size = numbers.length;
        int temp = 0;
        int j = 0;
        for (int i = 0; i < size; i++) {
            temp = numbers[i];
            //  假设temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                //  将大于temp的值整体后移一个单位
                numbers[j] = numbers[j-1];
            }
            numbers[j] = temp;
        }
        //  System.out.println(numberss.toString(numbers)+" insertSort");
    }
}
