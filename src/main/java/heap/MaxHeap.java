package heap;

/**
 * 大顶堆，用数组实现
 */
public class MaxHeap {
    // 容器
    private int[] array;

    // 记录当前保存了多少元素
    private int count;

    // 容量
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.array = new int[capacity];
    }

    /**
     * 数组建堆
     * @param arr
     */
    public void buildMaxHeap(int[] arr) {
        while (arr.length > this.capacity) {
            // 数组数据超过容量，需要扩容
            resize();
        }

        this.count = arr.length;
        for (int i = 0; i < arr.length; i++) {
            this.array[i] = arr[i];
        }

        // 从第一个非叶子节点位置开始下沉堆化
        for (int i = (this.count - 1) / 2; i >= 0; i--) {
            this.downForward(i);
        }
    }

    /**
     * 堆排序
     * @return
     */
    public int[] heapSort() {
        int[] sortedArr = new int[count];
        int oldCount = this.count;

        for (int i = this.count - 1; i > 0; i--) {
            // 交换最后一个leaf节点和root
            exch(0, i);

            this.count--;

            // root下沉堆化
            downForward(0);
        }

        for (int i = 0; i < oldCount; i++) {
            sortedArr[i] = this.array[i];
        }

        this.count = oldCount;
        return sortedArr;
    }

    /**
     * 父节点在数组中的位置
     * @param i
     * @return
     */
    public int parentIdx(int i) {
        if (i <= 0 || i >= this.count) {
            return -1;
        }

        return (i - 1) / 2;
    }

    /**
     * 左子节点在数组中的位置
     * @return
     */
    private int leftChildIdx(int i) {
        int left = 2 * i + 1;
        if (left >= this.count) {
            return -1;
        }
        return left;
    }

    /**
     * 右子节点在数组中的位置
     * @param i
     * @return
     */
    private int rightChildIdx(int i) {
        int right = 2 * i + 2;
        if (right >= this.count) {
            return -1;
        }
        return right;
    }

    /**
     * 从节点i开始下沉堆化
     * @param i
     */
    private void downForward(int i) {
        if (i >= this.count - 1) {
            return;
        }

        int left = this.leftChildIdx(i);
        int right = this.rightChildIdx(i);

        // 比较节点i与左、右子节点
        int maxIdx = this.maxIdx(i, left, right);
        if (maxIdx == -1 || maxIdx == i) {
            // 没有子节点了，或者左右子节点都比自己小，就结束
            return;
        }

        // 下沉
        this.exch(i, maxIdx);

        // 继续下沉
        downForward(maxIdx);
    }

    private int maxIdx(int i, int left, int right) {
        if (left == -1 && right == -1) {
            return -1;
        }

        int max = i;
        if (left != -1) {
            if (this.array[left] > this.array[max]) {
                max = left;
            }
        }

        if (right != -1) {
            if (this.array[right] > this.array[max]) {
                max = right;
            }
        }

        return max;
    }

    private void exch(int i, int j) {
        int tmp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = tmp;
    }

    /**
     * 双倍扩容
     */
    private void resize() {
        int[] oldArr = this.array;
        this.array = new int[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            this.array[i] = oldArr[i];
        }
        this.capacity = capacity * 2;
    }

    public int size() {
        return this.count;
    }

    /**
     * 分层打印
     */
    public void printHeapByLayer() {
        int history = 0;
        int h = 0;
        while (history < this.count) {
            System.out.print("layer_" + h + ": ");
            int layerCnt = 1 << h;

            int remain = this.count - history;
            int printSize = Math.min(remain, layerCnt);

            for (int i = history; i < history + printSize - 1; i++) {
                System.out.print(this.array[i] + ",");
            }
            System.out.println(this.array[history + printSize - 1]);

            history += printSize;
            h++;
        }
    }
}
