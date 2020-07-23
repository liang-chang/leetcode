package leetcode;

public class P206_Reverse_Linked_List_2 {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode next = head.next; //2345n
        head.next=null;             //1n
        return r0(head,next); //1n 2345n
    }

    public ListNode r0(ListNode pre,ListNode cur) {
        if(cur == null){     //1n 2345n    , 2345n 345n, 345n 45n , 45n 5n   ,5n n
            return pre;
        }                    //2345n  345n , 345n 45n  , 45n  5n  54n, 5n  n  5n,
        ListNode next = cur.next;
        ListNode head = r0(cur,next);
        cur.next=pre;
        pre.next = null;
        return head;
    }

}
