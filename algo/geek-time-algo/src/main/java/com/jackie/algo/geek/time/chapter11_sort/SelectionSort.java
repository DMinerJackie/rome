package com.jackie.algo.geek.time.chapter11_sort;

/**
 * @Author: Jackie
 * @date 2019/1/13
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{100,82,74,62,54,147};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        int length = arr.length;
        if (length <= 1) return;

        for (int i = 0; i < length - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
