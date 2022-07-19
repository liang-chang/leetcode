package lintcode;

import java.util.Deque;
import java.util.LinkedList;

public class P7_Serialize_and_Deserialize_Binary_Tree {

	public static void main(String[] args) {

		//广度优先序列化
		TreeNode deserialize = deserialize("3,9,20,#,#,15,7");
		
		String serialize = serialize(deserialize);
		
		System.out.println(serialize);
		TreeNode deserialize2 = deserialize(serialize);
		
//		System.out.println(serialize(deserialize("1,2,3")));
	}

  	public static String serialize(TreeNode root) {
  		
  		if(root == null){
  			return null;
  		}

		Deque<TreeNode> list = new LinkedList<>();

		list.addLast(root);

		TreeNode current = null;
		
		TreeNode nullNode = new TreeNode(-1);

		StringBuilder ret = new StringBuilder();

		while (list.size() > 0) {

			current = list.poll();

			ret.append(nodeToText(current) + ",");
			
			TreeNode node = null;
			
			node = current.left;
			
			if(nullNode(node)){
				if(current!=nullNode){
					list.addLast(nullNode);
				}
			}else{
				list.addLast(node);
			}
			
			node = current.right;
			
			if(nullNode(node)){
				if(current!=nullNode){
					list.addLast(nullNode);
				}	
			}else{
				list.addLast(node);
			}
		}
		
		return ret.substring(0, ret.length() - 1);
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

	public static int textToInt(String s) {
		return "#".equals(s) ? -1 : Integer.parseInt(s);
	}

	public static String nodeToText(TreeNode node) {
		return (node==null||node.val==-1)?"#":String.valueOf(node.val);
	}
	
	public static boolean nullNode(String s){
		return "#".equals(s);
	}
	
	public static boolean nullNode(TreeNode node){
		return node==null;
	}

	public static class TreeNode {
		public int val;
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
