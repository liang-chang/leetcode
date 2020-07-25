package leetcode;

public class P83_Remove_Duplicates_From_Sorted_List {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            //只有一个，肯定不重复
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        while (cur != null) {
            if (cur.val == pre.val) {
                //重复

                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
