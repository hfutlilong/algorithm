package sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度：平均：O(nlogn)，最好：O(nlogn)，最坏：O(nlogn)
 * 稳定性：稳定
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 3, 5, 1, 7, 9, 0, 6 };
        mergeSort(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));
    }

    private static void mergeSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);

        merge(arr, lo, mid, hi);
    }

    // 原地归并
    private static void merge(int[] arr, int lo, int mid, int hi) {
        // 拷贝一份新的数组
        int[] tempArr = Arrays.copyOf(arr, arr.length);

        int i = lo;
        int j = mid+ 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = tempArr[j++];
            } else if (j > hi) {
                arr[k] = tempArr[i++];
            } else if (tempArr[i] < tempArr[j]) {
                arr[k] = tempArr[i++];
            } else {
                arr[k] = tempArr[j++];
            }
        }
    }
}
