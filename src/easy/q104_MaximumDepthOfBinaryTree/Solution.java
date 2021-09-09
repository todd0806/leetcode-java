package easy.q104_MaximumDepthOfBinaryTree;

/**
 * @author Todd
 *https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution {
	
	/**
	 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/acmjin-pai-chao-qing-xi-jiang-jie-di-gui-5fbq/
	 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		int maxHeight = Math.max(leftHeight, rightHeight) + 1;
		return maxHeight;
	}
}
