package lintcode;

public class P36_Reverse_Linked_List_II {

    public static void main(String[] args) {
        ListNode list = null;

        list = generate(1, 2, 3, 4, 5, 6);
        System.out.println(list);
        System.out.println(reverseBetween(list,2,3));

        list = generate(1);
        System.out.println(list);
        System.out.println(reverseBetween(list,1,2));
    }

    /**
     * 1 ≤ m ≤ n ≤ length
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next=head;
        ListNode next    = head.next;
        head.next=null;

        ListNode t = null;
        for (; next.next != null; next = t) {
            t = next.next;
            next.next = newHead.next;
            newHead.next = next;
        }
        //最后一个
        next.next = newHead.next;
        newHead.next = next;

        return newHead.next;
    }

    public static ListNode generate(int... a) {
        if (a == null || a.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode next = head;
        for (int v : a) {
            ListNode current = new ListNode(v);
            next.next = current;
            next = current;
        }
        return head.next;
    }

    /**
     * Definition for ListNode
     */
    public static class ListNode {
        int      val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }

        @Override
        public String toString() {
            if (this.next == null) {
                return val + "";
            } else {
                return val + "->" + next.toString();
            }
        }
    }
}
