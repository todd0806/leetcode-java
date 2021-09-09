package medium.q236_LowestCommonAncestorOfABinaryTree;

/**
 * @author Todd
 *         https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Solution {
	/**https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-x-tl5b/
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right != null) {
			return root;
		}else if(left != null && right == null) {
			return left;
		}else if(left == null && right != null){
			return right;
		}else {
			return null;
		}
	}
}
