package leetcode;

import lintcode.P7_Serialize_and_Deserialize_Binary_Tree;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    public static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode deserialize = deserialize("3,5,1,6,2,0,8,#,#,7,4");

        System.out.println(deserialize);

//        lowestCommonAncestor();
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left  = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
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
        TreeNode[] nodeArray = new TreeNode[split.length];

        for (int j = split.length-1; j >= 0 ; j--) {
            int i=j+1;

            String value=split[j];
            if(nullNode(value)){
                //空节点什么都不做
                continue;
            }
            int lr = i^1;
            int pi = i/2;

            TreeNode child = nodeArray[i];
            child.val =Integer.parseInt(value);

            TreeNode parent = nodeArray[pi];

            if(lr >0 ){
                //父节点的右节点
                parent.right = child;
            }else{
                parent.left = child;
            }

        }
        return nodeArray[0];
    }

}
