package medium.q098_ValidateBinarySearchTree;

import java.util.Stack;

/**
 * @author Todd https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Solution {
	
//	https://leetcode-cn.com/problems/validate-binary-search-tree/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-er-ch-9cc0/
	long max = Long.MIN_VALUE;
	
	public boolean isValidBST(TreeNode root) {
		return traverse(root);
	}
	
	private boolean traverse(TreeNode root) {
		if (root == null) {
			return true;
		}
	
		boolean left = traverse(root.left);
		if (max < root.val) {
			max = root.val;
		} else {
			return false;
		}
		boolean right = traverse(root.right);
		return left && right;
	}

	
	/**方法一 迭代
	 * BST->中序-->遞增，所以中間有值比前一個值小，就代表不是BST
	 * @param root
	 * @return
	 * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-di-gui-yu-z-evm8/
	 */
	
//	public boolean isValidBST(TreeNode root) {
//		Integer pre = null;
//		Stack<TreeNode> stack = new Stack<>();		
//		while(!stack.isEmpty() || root != null) {
//			if(root != null) {
//				stack.push(root);
//				root = root.left;
//			}else {
//				root = stack.pop();
//				// 
//				if(pre!= null && root.val <= pre) {
//					return false;
//				}
//				pre = root.val;
//				root = root.right;
//			}
//		}
//		return true;
//	}
	
	/**方法二：遞迴
	 * 有一個測試case會cover到Integer.MIN_VALUE, 所以要用Long.MIN_VALUE才能比他小
	 * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
	 * @param root
	 * @return
	 */
//	public boolean isValidBST(TreeNode root) {
//		return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
//	}
//	
//	private boolean validate(TreeNode root, long lower, long upper) {
//		if(root == null) {
//			return true;
//		}
//		
//		if(root.val <= lower || root.val >= upper) {
//			return false;
//		}
//		
//		return validate(root.left, lower, root.val) && validate(root.right, root.val, upper); 
//	}
	
}
