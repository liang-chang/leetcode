package leetcode;

import lintcode.P35_Reverse_Linked_List;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P148_Sort_List {
    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "{" +
                    "v=" + val +
                    ", l=" + left +
                    ", r=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode deserialize = generate(4,2,1,3);

        System.out.println(deserialize);

        sortList(deserialize);

    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head ;
        }

        return mergeSort(head);
    }

    public static ListNode findMindle(ListNode head){
        ListNode slow = head ;
        ListNode fast = head.next ; // 1 2 3 4 5
        while(fast!=null  && fast.next !=null ){
            slow = slow.next ;               //2  3
            fast = fast.next.next ;          //3  5
        }
        return slow ; //3
    }

    public static ListNode mergeSortedList(ListNode a,ListNode b){
        ListNode dummy = new ListNode(-9999);
        ListNode tail = dummy;
        while(a != null && b != null){
            if(a.val < b.val){
                tail.next=a;
                a=a.next;
            }else{
                tail.next=b;
                b=b.next;
            }
            tail = tail.next;
        }
        while(a != null){
            tail.next=a;
            a=a.next;
            tail = tail.next;
        }
        while(b != null){
            tail.next=b;
            b=b.next;
            tail = tail.next;
        }
        return dummy.next ;
    }

    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode middle = findMindle(head); // 3
        ListNode nextHead = middle.next; //1 2 3 , 4 5
        middle.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextHead);

        ListNode result = mergeSortedList(left,right);
        return result;
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
