package lintcode;

import java.util.Arrays;
import java.util.List;

class P104_Merge_K_Sorted_Lists {

	public static void main(String[] args) {

		ListNode m = mergeKLists(Arrays.asList(N(2, N(4, null)), N(null),
				N(-1, null)));

		System.out.println(m);

		m = mergeKLists(Arrays.asList(N(2, N(6, null)), N(5, null), N(7, null)));

		System.out.println(m);
	}

	public static ListNode mergeKLists(List<ListNode> lists) {

		ListNode root = null;
		int i = 0;
		for (i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				root = lists.get(i);
				break;
			}
		}

		if (root == null) {
			return root;
		}

		for (int j = i + 1; j < lists.size(); j++) {
			root = merge(root, lists.get(j));
		}

		return root;

	}

	public static ListNode merge(ListNode a, ListNode b) {

		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		ListNode root = null;

		if (a.val <= b.val) {
			root = a;
			a = a.next;
		} else {
			root = b;
			b = b.next;
		}

		ListNode currA = a;

		ListNode currB = b;

		ListNode tail = root;

		while (currA != null && currB != null) {

			if (currA.val <= currB.val) {
				tail.next = currA;
				currA = currA.next;

			} else {
				tail.next = currB;
				currB = currB.next;
			}
			tail = tail.next;
		}

		while (currA != null) {
			tail.next = currA;
			currA = currA.next;
			tail = tail.next;
		}

		while (currB != null) {
			tail.next = currB;
			currB = currB.next;
			tail = tail.next;
		}

		return root;
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
