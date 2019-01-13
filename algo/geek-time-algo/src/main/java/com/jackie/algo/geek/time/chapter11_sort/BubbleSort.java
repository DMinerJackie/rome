package com.jackie.algo.geek.time.chapter11_sort;

/**
 * @Author: Jackie
 * @date 2019/1/12
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{100,82,74,62,54,147};
        bubbleSort(arr);
        bubbleSort2(arr);
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
        if (length <= 1) {
            return;
        }

        int temp;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    flag = true;
                }
            }

            if (!flag) {
                System.out.println("total loop: " + (i+1) + " times, stop at index:" + i);
                break;
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 和上面的不同之处在于，上面的是保证数组从后往前有序，这里的是保证从前往后的有序
     * 上面的做法如下所示，每次要遍历的元素如下
     * a[0],a[1],a[2],a[3],a[4],a[5]
     * a[0],a[1],a[2],a[3],a[4]     (这里不再遍历a[5]的位置，因为a[5]在第一轮遍历已是最大，不需要参与遍历，下面遍历同理)
     * a[0],a[1],a[2],a[3]
     * a[0],a[1],a[2]
     * a[0],a[1]
     * a[0]
     *
     * 下面的做法如下所示，每次要遍历的元素如下
     * a[0],a[1],a[2],a[3],a[4],a[5]
     *      a[1],a[2],a[3],a[4],a[5]   (这里不再遍历a[0]的位置，因为a[0]在第一轮遍历已是最小，不需要参与遍历，下面遍历同理)
     *           a[2],a[3],a[4],a[5]
     *                a[3],a[4],a[5]
     *                     a[4],a[5]
     *                          a[5]
     */
    public static void bubbleSort2(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return;
        }

        int temp;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = length - 1; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;

                    flag = true;
                }
            }

            if (!flag) {
                System.out.println("total loop: " + (length - i - 1) + " times, stop at index:" + i);
                break;
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
