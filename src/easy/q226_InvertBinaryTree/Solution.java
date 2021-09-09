package easy.q226_InvertBinaryTree;

/**
 * @author Todd
 *https://leetcode.com/problems/invert-binary-tree/description/
 */
public class Solution {
	public TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;
	}
	
	private void invert(TreeNode root) {
		// terminator
		if(root == null) {
			return;
		}
		
		// process logic
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		// drilldown
		invert(root.left);
		invert(root.right);
		
		// reverse state
	}
}
