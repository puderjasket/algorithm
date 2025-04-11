package datastructures;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	
	public static void main(String[] args) {
		
	}
    public List<Integer> preorderTraversal(TreeNode root) {
    	//中序遍历和后序遍历类似
        List<Integer> L = new ArrayList<Integer>();
        if(root==null) return L;
        L.add(root.val);
        L.addAll(preorderTraversal(root.left));
        L.addAll(preorderTraversal(root.right));
    	return L;
    }

}

class TreeNode {
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


