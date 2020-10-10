package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P103_Binary_Tree_Zigzag_Level_Order_Traversal_2 {
    public static class TreeNode {
        int val;
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
        TreeNode[] deserialize = deserialize("3,5,1,6,2,0,8,#,#,7,4");

        System.out.println(deserialize);
        List<List<Integer>> lists = zigzagLevelOrder(deserialize[0]);
        System.out.println(lists);
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ret = new LinkedList<>();

        Deque<TreeNode> q = new LinkedList<>();
        q.push(root);

        int level = 1;

        while (q.size() > 0) {
            LinkedList<Integer> list = new LinkedList<>();

            int levelSize = q.size();
            for (; levelSize > 0; levelSize--) {
                TreeNode treeNode = q.poll();

                if (treeNode.left != null) {
                    q.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    q.addLast(treeNode.right);
                }

                if((level & 1) == 0){
                    //偶
                    list.addFirst(treeNode.val);
                }else{
                    //奇
                    list.addLast(treeNode.val);
                }
            }
            ret.add(list);
            level ++;

        }
        return ret;
    }

    public static boolean nullNode(String s) {
        return "#".equals(s);
    }

    public static int textToInt(String s) {
        return "#".equals(s) ? -1 : Integer.parseInt(s);
    }

    public static TreeNode[] deserialize(String data) {

        if (data == null) {
            return null;
        }
        String[] split = data.split(",");
//        TreeNode[] nodeArray = new TreeNode[split.length];
        TreeNode[] nodeArray = IntStream.range(0, split.length)
                .boxed()
                .map(i -> new TreeNode(0))
                .collect(Collectors.toList()).toArray(new TreeNode[0]);

        for (int i = split.length - 1; i > 0; i--) {

            String value = split[i];
            if (nullNode(value)) {
                //空节点什么都不做
                continue;
            }
            int lr = i & 1;
            int pi = (i - 1) >> 1;

            TreeNode child = nodeArray[i];
            child.val = Integer.parseInt(value);

            TreeNode parent = nodeArray[pi];

            if (lr == 0) {
                //父节点的右节点
                parent.right = child;
            } else {
                parent.left = child;
            }

        }
        nodeArray[0].val = Integer.parseInt(split[0]);
        return nodeArray;
    }

}
