package lintcode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class P15_Permutations_2 {

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

        List<List<Integer>> result = new ArrayList<>(1);
        if (nums == null || nums.length <= 0) {
            result.add(Collections.emptyList());
            return result;
        }

        List<Integer> numList = Arrays.stream(nums)
                .boxed()
                .collect(java.util.stream.Collectors.toList());

        return permute0(numList);

    }

    public static List<List<Integer>> permute0(List<Integer> numList) {
        List<List<Integer>> r = new ArrayList<>();

        if (numList.isEmpty()) { // 当前排列已完成
            r.add(Collections.emptyList());
            return r;
        }
        Integer f = numList.get(0);
        numList.remove(0);

        List<List<Integer>> lastComp = permute0(numList);

        for (List<Integer> comp : lastComp) {
            for (int i = 0; i <= comp.size(); i++) {
                List<Integer> t = new ArrayList<>(comp.size() + 1);
                t.addAll(0, comp.subList(0, i));
                t.add(i, f);
                t.addAll(i + 1, comp.subList(i, comp.size()));

                r.add(t);
            }
        }

        return r;
    }

}
