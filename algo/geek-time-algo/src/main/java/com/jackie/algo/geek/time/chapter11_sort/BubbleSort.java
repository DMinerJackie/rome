package com.jackie.algo.geek.time.chapter11_sort;

/**
 * @Author: Jackie
 * @date 2019/1/12
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{100,82,74,62,54,47,38,29};
        bubbleSort(arr);
    }

    /**
     * 外层i的循环代表比较的趟数，内层j的循环代表的元素位置
     *  a[0],a[1],a[2],a[3],a[4],a[5]
     *  第一趟走完，最大的元素冒泡到最后a[5]的位置，需要比较的位置即为：
     *  a[0],a[1],a[2],a[3],a[4]
     *  所以可以看到j的终止条件是动态变化的，与i的位置相关，趟数每增加一次，终止的位置就往前挪一个，因为每次都能固定一个元素
     *
     *  注意这里的边界条件，是<还是<=
     *  第一层是小于，因为是从0开始，对于上面的例子来说，是比较length-1=6-1=5趟，因为总共6个元素，只要5趟就能比较完成
     *  好比有两个元素，只要一趟就能比较完成
     *  第二层是同样的道理，假设在i=0时，length-i-1=6-0-1=5，
     *  但是这里<，所以只会到j=4，乍一看你会觉得之比较到了a[j]=a[4]，最后a[5]是不是就丢了
     *  其实不是，仔细看下面的比较条件就会发现有a[j+1]即a[5]
     *  所以，综上内层和外层都是从0开始，且都是<而不是<=
     */
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
