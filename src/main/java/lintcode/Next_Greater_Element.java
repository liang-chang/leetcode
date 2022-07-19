package lintcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Next_Greater_Element {

	public static void main(String[] args) {
		int[] nums={2,1,2,4,3};
		int[] ints = nextGreaterElement(nums);
		System.out.println(ints);
	}

	static int[] nextGreaterElement(int[] nums) {
		int n = nums.length;
		// 存放答案的数组
		int[]          res = new int[n];
		Stack<Integer> s   = new Stack<>();
		// 倒着往栈里放
		for (int i = n - 1; i >= 0; i--) {
			// 判定个子高矮
			while (!s.isEmpty() && s.peek() <= nums[i]) {
				// 矮个起开，反正也被挡着了。。。
				s.pop();
			}
			// nums[i] 身后的更大元素
			res[i] = s.isEmpty() ? -1 : s.peek();
			s.push(nums[i]);
		}
		return res;
	}

}
