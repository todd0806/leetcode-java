package medium.q105_ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.Arrays;

/**
 * @author Todd
 *https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {
	/**https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/dong-hua-yan-shi-105-cong-qian-xu-yu-zhong-xu-bian/
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		
		// 前序的第一個元素是根節點
		TreeNode root = new TreeNode(preorder[0]);
		for(int i = 0; i < inorder.length; i++) {
			// 中序的中間元素為根節點
			if(preorder[0] == inorder[i]) {
				int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
				int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
				int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
				int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
				root.left = buildTree(preLeft, inLeft);
				root.right = buildTree(preRight, inRight);
				break;
			}
		}
		
		return root;
	}
}
