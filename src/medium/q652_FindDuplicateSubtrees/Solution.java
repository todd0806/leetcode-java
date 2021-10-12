package medium.q652_FindDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/find-duplicate-subtrees/submissions/
public class Solution {
	// https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487527&idx=1&sn=9cf2b0d8608ba26ea7c6a5c9b41d05a1&chksm=9bd7ee2faca0673916bf075539bf6fc3c01f3dcc0b298b3f507047692ef5c850ed9cfe82e4e6&scene=178&cur_album_id=1318896187793260544#rd
	List<TreeNode> ans = new ArrayList<>();
	HashMap<String, Integer> map = new HashMap<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		traverse(root);
		return ans;
	}

	private String traverse(TreeNode root) {
		// terminator
		if (root == null) {
			return "#";
		}

		String left = traverse(root.left);
		String right = traverse(root.right);
		String nodeString = left + "," + right + "," + root.val;
		map.put(nodeString, map.getOrDefault(nodeString, 0) + 1);
		if (map.getOrDefault(nodeString, 0) == 2) {
			ans.add(root);
		}
		return nodeString;
	}
}
