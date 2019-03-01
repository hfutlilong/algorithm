package heap;

import com.alibaba.fastjson.JSON;

public class Test {
    public static void main(String[] args) {
        int[] arr = {31,1,21,5,10,12,18,3,2,8,7};

        // 数组建堆
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.buildMaxHeap(arr);

        System.out.println("数组建堆结果：");
        maxHeap.printHeapByLayer();

        // 堆排序
        int[] sortedArr = maxHeap.heapSort();

        System.out.println();
        System.out.println("堆排序结果：");
        System.out.println(JSON.toJSON(sortedArr));
    }
}
