package com.jinfeng.spark.sort;

import java.util.Arrays;

/**
 * Project : Spark
 * Package : com.jinfeng.spark.sort
 * Author : WangJinfeng
 * Date : 2017-11-05 15:03
 * Email : wangjinfeng@yiche.com
 * Phone : 152-1062-7698
 * <p>
 * 堆排序
 * 基本思想：
 * 堆排序是一种树形选择排序，是对直接选择排序的有效改进
 * 堆的定义：
 * 具有n个元素的序列（h1,h2,...,hn），当且仅当满足（hi>=h2i,hi>=h(2i+1)）或(hi<=h2i,hi<=h(2i+1))
 * (i=1,2,...,n/2)时称之为堆。堆顶为根，其他为左子树，右子树。
 * 思想：
 * 初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这个堆的根节点的数最大。
 * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。以此类推，直到只有两个节点的堆，并对它
 * 们作交换，最后得到有n个节点的有序序列。从算法描述来看，堆排序需要两个过程，一是建堆，二是堆顶与堆的最后一个元素交
 * 换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 *
 * 堆排序是不稳定排序
 * 时间复杂度：
 *      平均：O(nlog2n)
 *      最好：O(nlog2n)
 *      最坏：O(nlog2n)
 */
public class HeapSort {

    public static void heapSort(int[] numbers) {
        //  int[] numbers = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64};
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            //  建堆
            buildMaxHeap(numbers, length - 1 - i);
            //  交换堆顶和最后一个元素
            swap(numbers, 0, length - 1 - i);
            System.out.println(Arrays.toString(numbers));
        }
    }

    //  对numbers数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] numbers, int lastIndex) {
        //  从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i > 0; i--) {
            //  k保存正在判断的节点
            int k = i;
            //  如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                //  k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //  如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    //  如果右子节点的值较大
                    if (numbers[biggerIndex] < numbers[biggerIndex + 1]) {
                        //  biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //  如果k节点的值小于其较大的子节点的值
                if (numbers[k] < numbers[biggerIndex]) {
                    //  交换他们
                    swap(numbers, k, biggerIndex);
                    //  将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其
                    //  左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
