package lintcode;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class P11_Search_Range_in_Binary_Search_Tree {

    public static void main(String[] args) {
        TreeNode deserialize = deserialize("20,8,22,4,12");

        List<Integer> integers = searchRange(deserialize("20,8,22,4,12"), 10, 22);
        System.out.println(integers);

    }

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {

        List<Integer> result = new LinkedList<>();

        find(result,root,k1,k2);

        return result;
    }

    public static void find(List<Integer> result,TreeNode root,int k1, int k2){
        if(root==null){
            return;
        }

        if(root.val>=k1 && root.val <= k2){
            result.add(root.val);
        }

        find(result,root.left,k1,k2);
        find(result,root.right,k1,k2);
    }


    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

    }


    public static boolean nullNode(String s){
        return "#".equals(s);
    }

    public static int textToInt(String s) {
        return "#".equals(s) ? -1 : Integer.parseInt(s);
    }

    public static TreeNode deserialize(String data) {

        if(data == null){
            return null;
        }

        String[] split = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(split[0]));

        Deque<TreeNode> list = new LinkedList<>();

        list.addLast(root);

        TreeNode current = null;

        for (int i = 0; i < split.length; i++) {
            int left = i * 2 + 1;
            int right = left + 1;

            if (left >= split.length) {
                break;
            }

            current = list.poll();

            String sl=split[left];
            String sr=split[right];

            if(!nullNode(sl)){
                list.addLast(current.left = new TreeNode(textToInt(sl)));
            }

            if(!nullNode(sr)){
                list.addLast(current.right = new TreeNode(textToInt(sr)));
            }
        }
        return root;
    }



}