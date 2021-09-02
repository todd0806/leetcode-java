package easy.q144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Todd 
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class Solution {
	
	/**方法一：遞迴
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preOrder(root, res);
		return res;
	}
	
	private void preOrder(TreeNode root, List<Integer> res) {
		if(root == null) {
			return;
		}
		res.add(root.val);
		preOrder(root.left, res);
		preOrder(root.right, res);
	}
	
	/**方法二：迭代
	 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-qian-zhong-hou-xu-die-dai-bia-ozsw/
	 * @param root
	 * @return
	 */
//	public List<Integer> preorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<>();
//		Deque<TreeNode> deque = new LinkedList<>();
//		while(root != null || !deque.isEmpty()) {
//			if(root != null) {
//				res.add(root.val);
//				deque.push(root);
//				root = root.left;
//			}else {
//				root = deque.pop();
//				root = root.right;
//			}
//		}
//		return res;
//	}
}
