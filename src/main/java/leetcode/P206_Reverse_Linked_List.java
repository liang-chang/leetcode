package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P206_Reverse_Linked_List {
  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = head;  //12345n
        ListNode cur = head.next; //2345n
        pre.next = null ;     //1n
        ListNode next = null;
        while(cur != null){  //2345n  345n  45n    5n
            next = cur.next; //345n   45n   5n     n
            cur.next = pre;  //21n    321n  4321n  54321n
            pre = cur;       //21n    321n  4321n  54321n
            cur = next;      //345n   45n   5n     n
        }

        return pre;
    }

}
