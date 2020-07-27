package leetcode;

public class P701_Insert_into_a_Binary_Search_Tree {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if( root == null){
            return new TreeNode(val);
        }
        if(val > root.val ){
            //插入到右子树
            root.right = insertIntoBST(root.right,val);
        }else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }

}
