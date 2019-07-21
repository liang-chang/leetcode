package lintcode;

import java.util.HashSet;
import java.util.Set;

public class P124_Longest_Consecutive_Sequence {

	public static void main(String[] args) {

		System.out.println(I(100, 4, 200, 1, 3, 2));
		
		System.out.println(I(1,2,0,1));

	}

	public static int I(int... a) {

		return longestConsecutive(a);

	}

	public static int longestConsecutive(int[] nums) {

		if (nums.length <= 1) {
			return nums.length;
		}

		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		int max = 0;

		for (Integer num : nums) {

			int counter = 0;

			int u = num;
			while (set.contains(u)) {
				set.remove(u);
				counter++;
				u++;
			}

			int d = num-1;
			while (set.contains(d)) {
				set.remove(d);
				counter++;
				d--;
			}

			max = counter > max ? counter : max;

		}

		return max;
	}
}
