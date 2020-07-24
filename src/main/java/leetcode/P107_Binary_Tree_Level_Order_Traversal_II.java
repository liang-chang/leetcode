package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P107_Binary_Tree_Level_Order_Traversal_II {
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
        TreeNode[] deserialize = deserialize("3,5,1,6,2,0,8,#,#,7,4");

        System.out.println(deserialize);


        List<List<Integer>> lists = levelOrderBottom(deserialize[0]);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = levelOrder(root);

        //0 1 2 3 4 5
        //0 1 2 3 4

        for(int i=0,j = lists.size()/2 ,len =lists.size() ; i < j ; i++){
            List<Integer> t = lists.get(i);
            lists.set(i,lists.get(len-1-i));
            lists.set(len-1-i,t);
        }
        return lists;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            //Collection.emptyList();
            return new ArrayList<>(0);
        }

        List<List<Integer>> ret = new LinkedList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int leftCnt = 1;//放入头结点

        while(deque.size() > 0){
            List<Integer> level = new ArrayList<>(deque.size()*2);
            for(int i=0 ; i< leftCnt ; i++){
                TreeNode node = deque.poll();
                level.add(node.val);
                if(node.left != null){
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    deque.addLast(node.right);
                }
            }
            leftCnt = deque.size();
            ret.add(level);
        }
        return ret;
    }

    public static boolean nullNode(String s){
        return "#".equals(s);
    }

    public static int textToInt(String s) {
        return "#".equals(s) ? -1 : Integer.parseInt(s);
    }

    public static TreeNode[] deserialize(String data) {

        if(data == null){
            return null;
        }
        String[] split = data.split(",");
//        TreeNode[] nodeArray = new TreeNode[split.length];
        TreeNode[] nodeArray = IntStream.range(0, split.length)
                .boxed()
                .map(i -> new TreeNode(0))
                .collect(Collectors.toList()).toArray(new TreeNode[0]);

        for (int i = split.length - 1 ; i > 0 ; i--) {

            String value=split[i];
            if(nullNode(value)){
                //空节点什么都不做
                continue;
            }
            int lr = i&1;
            int pi = (i-1)>>1;

            TreeNode child = nodeArray[i];
            child.val =Integer.parseInt(value);

            TreeNode parent = nodeArray[pi];

            if(lr == 0 ){
                //父节点的右节点
                parent.right = child;
            }else{
                parent.left = child;
            }

        }
        nodeArray[0].val =Integer.parseInt(split[0]);
        return nodeArray;
    }

}
