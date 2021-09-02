package easy.q094_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Todd
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 */
public class Solution {
	
	 /**方法一：递归
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inOrder(root, res);
		return res;
	}
	
	private void inOrder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		inOrder(root.left, res);
		res.add(root.val);
		inOrder(root.right, res);
	}
	
	/**方法二：迭代
	 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-qian-zhong-hou-xu-die-dai-bia-ozsw/
	 * @param root
	 * @return
	 * 
	 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/dong-hua-yan-shi-94-er-cha-shu-de-zhong-xu-bian-li/
	 */
//	public List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		Stack<TreeNode> stack = new Stack<>();
//		while(root != null || !stack.empty()) {
//			if(root != null) {
//				stack.push(root);
//				root = root.left;
//			}else {
//				root = stack.pop();
//				res.add(root.val);
//				root = root.right;
//			}
//		}
//		return res;
//	}
}
