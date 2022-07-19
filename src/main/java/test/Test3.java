package test;

import java.util.concurrent.locks.LockSupport;

public class Test3 {

    public static void main(String[] args) {
        int[] nums = {0, 2, 4, 6, 8, 9};
        System.out.println(left_bound(nums, 7));
    }

    static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left  = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }
}
