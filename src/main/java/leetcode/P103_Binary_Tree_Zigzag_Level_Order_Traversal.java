package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P103_Binary_Tree_Zigzag_Level_Order_Traversal {
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

        int first = 0;
        int second = 0;

        System.out.println(first = 1 - first);
        System.out.println(second = 1 - first);


        List<List<Integer>> lists = zigzagLevelOrder(deserialize[0]);
        System.out.println(lists);
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ret = new LinkedList<>();

        List<Deque<TreeNode>> stacks = new ArrayList<>(2);
        stacks.add(new LinkedList<>());
        stacks.add(new LinkedList<>());

        int cur = 0;
        int next = 1;
        Deque<TreeNode> curStack = stacks.get(cur);
        Deque<TreeNode> nextStack = stacks.get(next);
        curStack.push(root);

        while (curStack.size() > 0 || nextStack.size() > 0) {
            List<Integer> nv = new LinkedList();
            while (curStack.size() > 0) {
                TreeNode node = curStack.pop();
                nv.add(node.val);
                if (cur == 0) {
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                }
            }
            cur = 1 - cur;
            next = 1 - next;
            ret.add(nv);
            curStack = stacks.get(cur);
            nextStack = stacks.get(next);
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
