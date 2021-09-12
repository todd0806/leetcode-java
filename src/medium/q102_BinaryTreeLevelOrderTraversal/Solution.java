package medium.q102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Todd https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Solution {
	/**BFS
	 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
	 * @param root
	 * @return
	 */
//	public List<List<Integer>> levelOrder(TreeNode root) {
//		List<List<Integer>> result = new ArrayList<>();
//		if(root == null) {
//			return result;
//		}
//		
//		Deque<TreeNode> deque = new LinkedList<>();
//		deque.add(root);
//		while(!deque.isEmpty()) {
//			int n = deque.size();
//			List<Integer> levelList = new ArrayList<>();
//			for(int i = 0; i < n; i++) {
//				TreeNode node = deque.pop();
//				levelList.add(node.val);
//				
//				if(node.left != null) {
//					deque.add(node.left);
//				}
//				
//				if(node.right != null) {
//					deque.add(node.right);
//				}
//			}
//			result.add(levelList);
//		}
//		
//		return result;
//	}
	
	
	/**DFS
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		dfs(1, root, result);
		return result;
	}
	
	private void dfs(int level, TreeNode node, List<List<Integer>> result) {
		if(result.size() < level) {
			result.add(new ArrayList<>());
		}
		
		result.get(level - 1).add(node.val);
		if(node.left != null) {
			dfs(level + 1, node.left, result);
		}
		if(node.right != null) {
			dfs(level + 1, node.right, result);
		}
	}
	
	
}
