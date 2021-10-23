package easy.q101_SymmetricTree;
// https://leetcode.com/problems/symmetric-tree
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		return isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeNode left, TreeNode right){
		if(left == null || right == null){
			return left == right;
		}
		
		if(left.val != right.val){
			return false;
		}else{
			return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
		}
	}

}
