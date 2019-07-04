package lintcode;

import java.util.PriorityQueue;

public class P5_Kth_Largest_Element {

	public static void main(String[] args) {

		System.out.println(kthLargestElement(1, new int[] { 1, 3, 4, 2 }));

		System.out.println(kthLargestElement(3, new int[] { 9, 3, 2, 4, 8 }));
	}

	public static int kthLargestElement(int n, int[] nums) {

		PriorityQueue<Integer> r = new PriorityQueue<>(n);

		r.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];

			Integer peek = r.peek();

			if (r.size() < n) {
				r.add(num);
				continue;
			}

			if (num > peek) {
				r.poll();
				r.add(num);
			}
		}

		return r.peek();
	}
}
