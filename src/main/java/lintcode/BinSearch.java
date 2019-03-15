package lintcode;

public class BinSearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 10};

        System.out.println(binarySearch(nums, 6));
    }

    public static int binarySearch(int[] nums, int target) {
        // write your code here
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (nums.length) / 2;

        int tmp = -1;

        while (lo != hi && mid != lo && mid != hi) {
            if (nums[mid] >= target) {
                hi = mid;
                if (nums[mid] == target) {
                    tmp = mid;
                }
            } else if (nums[mid] < target) {
                lo = mid;
            }

            mid = (lo + hi) / 2;
        }

        if (tmp != -1) {
            return tmp;
        }

        if (mid == lo && nums[lo] == target) {
            return mid;
        }

        if (mid == hi && nums[hi] == target) {
            return mid;
        }

        if (nums[mid] == target) {
            return mid;
        }

        return -1;

    }
}
