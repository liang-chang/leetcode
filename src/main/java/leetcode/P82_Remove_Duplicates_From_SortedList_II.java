package leetcode;

public class P82_Remove_Duplicates_From_SortedList_II {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            //只有一个节点,一定相等
            return head;
        }
        ListNode dummy = new ListNode(-9999999);
        dummy.next = head ;
        head = dummy;

        ListNode pre = null, cur = head , next = null ;
        int rmVal = 0 ;

        for( ; cur.next != null && cur.next.next != null ; ){
            if(cur.next.val == cur.next.next.val ){
                rmVal = cur.next.val;
                //当前和下一相等
                for( ; cur.next != null && cur.next.val == rmVal ; ){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
