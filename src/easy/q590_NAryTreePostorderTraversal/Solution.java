package easy.q590_NAryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Todd
 *https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class Solution {
	
	/**方法一：遞迴
	 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/n-cha-shu-de-hou-xu-bian-li-di-gui-zhen-tmlzn/
	 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/discuss/147959/Java-Iterative-and-Recursive-Solutions
	 * @param root
	 * @return
	 */
//	public List<Integer> postorder(Node root) {
//		List<Integer> value = new ArrayList<>();
//		post(root, value);
//		return value;
//	}
//
//	private void post(Node root, List<Integer> value) {
//		if (root != null) {
//			for (Node cur : root.children) {
//				post(cur, value);
//			}
//			value.add(root.val);
//		}
//	}
	
	/**方法二：迭代
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(Node root) {
		List<Integer> ans = new ArrayList<>();
		Deque<Node> deque = new LinkedList<>();
		deque.add(root);
		while(!deque.isEmpty()) {
			Node node = deque.pop();
			if(node != null) {
				for(Node child: node.children) {
					deque.push(child);
				}	
				ans.add(node.val);
			}
		}
		Collections.reverse(ans);
		return ans;
	}

}
