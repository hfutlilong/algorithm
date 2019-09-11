package sort;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序 时间复杂度
 * 平均：O(n^2)，最好：O(n)，最坏：O(n^2)
 * 稳定性：稳定
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 3, 5, 1, 7, 9, 0 };
        insertSort(a);
        System.out.println(JSON.toJSONString(a));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] >= arr[j - 1]) {
                    break;
                }
                exch(arr, j, j - 1);
            }
        }
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
