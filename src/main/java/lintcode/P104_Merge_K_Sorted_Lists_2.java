package lintcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class P104_Merge_K_Sorted_Lists_2 {

	public static void main(String[] args) {

		ListNode m = mergeKLists(Arrays.asList(N(2, N(4, null)), N(null),
				N(-1, null)));

		System.out.println(m);

		m = mergeKLists(Arrays.asList(N(2, N(6, null)), N(5, null), N(7, null)));

		System.out.println(m);
	}

	public static ListNode mergeKLists(List<ListNode> lists) {

		ListNode root = new ListNode(0);
		ListNode tail = root;

		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(),
				Comparator.comparingInt(a -> ((ListNode) a).val));

		while (true) {

			ListNode start = tail;

			for (int i=0,len=lists.size();i<len;i++) {
				
				ListNode node = lists.get(i);

				if (node == null) {
					continue;
				}
				
				lists.set(i, node.next);

				if (!queue.offer(node)) {
					tail.next = queue.poll();
					tail = tail.next;
				}
			}

			if (start == tail && queue.size() == 0) {
				break;
			}

			tail.next = queue.poll();
			tail = tail.next;
		}

		return root.next;
	}

	public static ListNode N(int val, ListNode node) {
		ListNode ret = new ListNode(val);
		ret.next = node;
		return ret;
	}

	public static ListNode N(ListNode node) {
		return node;
	}

	/**
	 * Definition for ListNode.
	 */
	public static class ListNode {

		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
