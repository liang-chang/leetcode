package lintcode;

import java.util.Deque;
import java.util.LinkedList;

public class P7_Serialize_and_Deserialize_Binary_Tree_2 {

    public static void main(String[] args) {

        //前序遍历序列化及反序列化

        String data = "1,2,#,4,#,#,3,#,#,";
        TreeNode deserialize = deserialize(data);

        // 用于拼接字符串
        StringBuilder sb = new StringBuilder();
        serialize(deserialize, sb);

        System.out.println(sb.toString());
    }

    // 代表分隔符的字符
    static String SEP  = ",";
    // 代表 null 空指针的字符
    static String NULL = "#";

    /* 将二叉树打平为字符串 */
    static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        /****** 前序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/

        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    LinkedList<Integer> res;

    /* 将二叉树打平为字符串 */
    static void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        /****** 前序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/

        traverse(root.left, sb);
        traverse(root.right, sb);
    }


    /* 主函数，将字符串反序列化为二叉树结构 */
    static TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    static TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        /****** 前序遍历位置 ******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;

        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


    public static class TreeNode {
        public int      val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "[l=" + left + ",v=" + val + ",r=" + right + "]";
        }

    }

}
