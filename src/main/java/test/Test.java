package test;

import java.util.LinkedHashMap;

public class Test {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(nums, 8));

    }

    static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return -1;
    }
}
