package easy.q145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Todd
 *https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class Solution {
	/**方法一：遞迴
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		postOrder(root, res);
		return res;
	}
	
	private void postOrder(TreeNode root ,List<Integer> res) {
		if(root == null) {
			return;
		}
		postOrder(root.left, res);
		postOrder(root.right, res);
		res.add(root.val);
	}
	
	/**方法二：迭代
	// 前序遍历顺序为：根 -> 左 -> 右
    // 后序遍历顺序为：左 -> 右 -> 根
    // 所以, 我们可以把前序遍历的稍作修改: 根 -> 右 -> 左, 
    // 然后结果存放到栈里进行倒序, 之后再遍历结果栈就可以输出后序遍历了
	 * @param root
	 * @return
	 */
//	public List<Integer> postorderTraversal(TreeNode root) {
//		Stack<TreeNode> all = new Stack<>();
//		Deque<TreeNode> deque = new LinkedList<>();
//		while(root != null || !deque.isEmpty()) {
//			if(root != null) {
//				all.push(root);
//				deque.push(root);
//				root = root.right;
//			}else {
//				root = deque.pop();
//				root = root.left;
//			}
//		}
//		
//		List<Integer> res = new ArrayList<>();
//		while(!all.isEmpty()) {
//			res.add(all.pop().val);
//		}
//		return res;
//	}
}
