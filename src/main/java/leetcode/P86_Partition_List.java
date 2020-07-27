package leetcode;

public class P86_Partition_List {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            //null or only one
            return head;
        }
        ListNode newLinkedHead = new ListNode(-9999);
        ListNode tail  = newLinkedHead;

        ListNode dummyHead = new ListNode(-9999);
        dummyHead.next=head;
        ListNode cur = dummyHead ;

        while( cur.next != null ){
            if(cur.next.val<x){
                cur = cur.next;
                continue;
            }else{
                ListNode t = cur.next;
                cur.next = cur.next.next;

                tail.next=t;
                t.next = null;
                tail = tail.next;
            }
        }
        cur.next=newLinkedHead.next;
        return dummyHead.next;
    }

}
