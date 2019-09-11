package sort;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 * 时间复杂度：平均：O(nlogn)，最好：O(nlogn)	O(n^2)
 * 稳定性：不稳定
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 3, 5, 1, 7, 9, 0, 6 };
        quickSort(a, 0, a.length - 1);
        System.out.println(JSON.toJSONString(a));
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            // i 向右移动
            while (arr[++i] < arr[lo]) {
                if (i == hi) {
                    break;
                }
            }

            // j 向左移动
            while (arr[--j] > arr[lo]) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(arr, i, j);
        }

        exch(arr, lo, j);
        return j;
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
