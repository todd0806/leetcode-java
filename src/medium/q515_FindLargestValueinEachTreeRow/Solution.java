package medium.q515_FindLargestValueinEachTreeRow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		// check
		if(root == null) {
			return result;
		}
		
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		
		while(!deque.isEmpty()) {
			int size = deque.size();
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < size; i++) {
				TreeNode node = deque.pop();
				if(node.val > max) {
					max = node.val;
				}
				if(node.left != null) {
					deque.add(node.left);
				}
				
				if(node.right!= null) {
					deque.add(node.right);
				}
			}
			result.add(max);
		}
		
		return result;
	}
}
