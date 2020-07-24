package lintcode;

import java.util.*;
import java.util.stream.Collectors;

class P15_Permutations {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));

        int[] nums2 = {};
        System.out.println(permute(nums2));


    }

    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length <= 0 ) {
            result.add(Collections.emptyList());
            return result;
        }


        List<Integer> numList = Arrays.stream(nums)
                .boxed()
                .collect(java.util.stream.Collectors.toList());

        DFS(result, numList, 0);

        return result;
    }

    public static void DFS(List<List<Integer>> result, List<Integer> nums, int pos) {
        if (pos == nums.size() - 1) { // 当前排列已完成
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = pos; i < nums.size(); i++) {
            swap(nums, pos, i); // 变换排列
            DFS(result, nums, pos + 1); // 继续生成
            swap(nums, pos, i);
        }
    }

    public static void swap(List<Integer> nums, int i, int j) {
        Integer t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }
}
