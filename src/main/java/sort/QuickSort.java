package sort;

/**
 * @Description 快排
 * @Author lilong
 * @Date 2019-02-27 17:14
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {9,5,3,8,7};
        new QuickSort().sort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public void sort(int[] a) {
        this.sort(a, 0, a.length - 1);
    }

    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = this.partition(a, lo ,hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int tmp = a[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (a[++i] <= tmp) {
                if (i == hi) {
                    break;
                }
            }

            while (a[--j] >= tmp) {
                if (j == lo) {
                    break;
                }
            }


            if (j <= i) {
                break;
            }

            exch (a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}