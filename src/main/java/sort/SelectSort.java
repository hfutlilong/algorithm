package sort;

import com.alibaba.fastjson.JSON;

/**
 * 选择排序
 * 时间复杂度：平均：O(n^2)，最好：O(n^2)，最坏：O(n^2)
 * 稳定性：不稳定
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 3, 5, 1, 7, 9, 0 };
        selectSort(a);
        System.out.println(JSON.toJSONString(a));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                exch(arr, i, min);
            }
        }
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
