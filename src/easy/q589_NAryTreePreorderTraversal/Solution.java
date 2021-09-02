package easy.q589_NAryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Todd
 *https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class Solution {
	/**方法一：遞迴
	 * @param root
	 * @return
	 */
//	public List<Integer> preorder(Node root) {
//		if(root == null) {
//			return Collections.emptyList();
//		}
//		List<Integer> ans = new ArrayList<>();
//		ans.add(root.val);
//		for(Node child: root.children) {
//			ans.addAll(preorder(child));
//		}
//		return ans;
//	}
	
	/**方法二：迭代
	 * @param root
	 * @return
	 */
	public List<Integer> preorder(Node root) {
		List<Integer> ans = new ArrayList<>();
		Deque<Node> deque = new LinkedList<>();
		
		deque.add(root);
		while(!deque.isEmpty()){
			Node node = deque.pop();
			if(node != null) {
				ans.add(node.val);
				for(int i = node.children.size() - 1; i>= 0; i--) {
					deque.push(node.children.get(i));
				}
			}
		}
		return ans;
	}
}
