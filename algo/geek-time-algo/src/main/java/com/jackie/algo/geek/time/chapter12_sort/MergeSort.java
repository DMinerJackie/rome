package com.jackie.algo.geek.time.chapter12_sort;

/**
 * @Author: Jackie
 * @date 2019/1/20
 *
 * https://www.cnblogs.com/of-fanruice/p/7678801.html
 * https://www.cnblogs.com/Java3y/p/8631584.html
 * 归并排序是稳定的排序
 * 时间复杂度为O(nlgn)
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[]{5,3,6,7,8,31,56,32,2};
        mergeSort(arr, 0,8);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 归并排序
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param R      指向数组最后一个元素
     */
    public static void mergeSort(int[] arrays, int L, int R) {

        //如果只有一个元素，那就不用排序了
        if (L == R) {
            return;
        } else {

            //取中间的数，进行拆分
            int M = (L + R) / 2;

            //左边的数不断进行拆分
            mergeSort(arrays, L, M);

            //右边的数不断进行拆分
            mergeSort(arrays, M + 1, R);

            //合并
            merge(arrays, L, M + 1, R);

        }
    }


    /**
     * 合并数组
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param M      指向数组分隔的元素
     * @param R      指向数组最后的元素
     */
    public static void merge(int[] arrays, int L, int M, int R) {

        //左边的数组的大小
        int[] leftArray = new int[M - L];

        //右边的数组大小
        int[] rightArray = new int[R - M + 1];

        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }


        int i = 0, j = 0;
        // arrays数组的第一个元素
        int  k = L;


        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {

            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arrays[k++] = leftArray[i++];
            } else {
                arrays[k++] = rightArray[j++];
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        /** 至于为什么可以直接把数组没有遍历的数据直接抄到大数组中，是因为在前面的拆分的时候已经拆到最小粒度了
         *  即已经到单个元素了，然后在进行每一个合并的时候，都是保证了各个小集合中是有序的，举例，假设经过上面的处理
         *  原来两个子集合的数据如下arr1：[1,5,6]  arr2：[2,3,4]
         *  那这时候显然左边的数组在排序后还剩下[5,6]是需要并入到大数组中的
         *  显然arr1和arr2本身都是有序的其次，如果arr2都遍历完了，那说明arr1中剩余的元素都是比arr2中的元素大
         *  而且arr1是有序，所以可以直接抄到大数组
         *
         *  下面的rightArray也是同样的道理
         */
        while (i < leftArray.length) {
            arrays[k++] = leftArray[i++];
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k++] = rightArray[j++];
        }
    }


    //========================这种方案简洁易懂==========================================


//
//
//    public static int[] sort(int[] a,int low,int high){
//        int mid = (low+high)/2;
//        if(low<high){
//            sort(a,low,mid);
//            sort(a,mid+1,high);
//            //左右归并
//            merge(a,low,mid,high);
//        }
//        return a;
//    }
//
//    public static void merge(int[] a, int low, int mid, int high) {
//        int[] temp = new int[high-low+1];
//        int i= low;
//        int j = mid+1;
//        int k=0;
//        // 把较小的数先移到新数组中
//        while(i<=mid && j<=high){
//            if(a[i]<a[j]){
//                temp[k++] = a[i++];
//            }else{
//                temp[k++] = a[j++];
//            }
//        }
//        // 把左边剩余的数移入数组
//        while(i<=mid){
//            temp[k++] = a[i++];
//        }
//        // 把右边边剩余的数移入数组
//        while(j<=high){
//            temp[k++] = a[j++];
//        }
//        // 把新数组中的数覆盖nums数组
//        for(int x=0;x<temp.length;x++){
//            a[x+low] = temp[x];
//        }
//    }



    //==================================================================

//    // 归并排序算法, a是数组，n表示数组大小
//    public static void mergeSort(int[] a, int n) {
//        mergeSortInternally(a, 0, n - 1);
//    }
//
//    // 递归调用函数
//    private static void mergeSortInternally(int[] a, int p, int r) {
//        // 递归终止条件
//        if (p >= r) return;
//
//        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
//        int q = p + (r - p) / 2;
//        // 分治递归
//        mergeSortInternally(a, p, q);
//        mergeSortInternally(a, q + 1, r);
//
//        // 将A[p...q]和A[q+1...r]合并为A[p...r]
//        merge(a, p, q, r);
//    }
//
//    private static void merge(int[] a, int p, int q, int r) {
//        int i = p;
//        int j = q + 1;
//        int k = 0; // 初始化变量i, j, k
//        int[] tmp = new int[r - p + 1]; // 申请一个大小跟a[p...r]一样的临时数组
//        while (i <= q && j <= r) {
//            if (a[i] <= a[j]) {
//                tmp[k++] = a[i++]; // i++等于i:=i+1
//            } else {
//                tmp[k++] = a[j++];
//            }
//        }
//
//        // 判断哪个子数组中有剩余的数据
//        int start = i;
//        int end = q;
//        if (j <= r) {
//            start = j;
//            end = r;
//        }
//
//        // 将剩余的数据拷贝到临时数组tmp
//        while (start <= end) {
//            tmp[k++] = a[start++];
//        }
//
//        // 将tmp中的数组拷贝回a[p...r]
//        for (i = 0; i <= r - p; ++i) {
//            a[p + i] = tmp[i];
//        }
//    }

}