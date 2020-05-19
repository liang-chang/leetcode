package lintcode;

public class P35_Reverse_Linked_List {

    public static void main(String[] args) {
        ListNode list = null;

        list = generate(1, 2, 3, 4, 5, 6);
        System.out.println(list);
        System.out.println(reverse(list));

        System.out.println(generate());
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head;
        ListNode next    = head.next;
        head.next=null;

        ListNode t=null;
        for (; next.next != null; next = t) {
            t = next.next;
            next.next = newHead;
            newHead.next = next;
        }
        return newHead;
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
