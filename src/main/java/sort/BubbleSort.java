package sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序
 * 时间复杂度：平均：O(n^2)，最好：O(n)，最坏：O(n^2)
 * 稳定性：稳定
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {4,5,2,3,5,7,9,0};
        bubbleSort(a);
        System.out.println(JSON.toJSONString(a));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j+1] < arr[j]) {
                    exch(arr, j, j + 1);
                }
            }
        }
    }

    private static void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
