package medium.q538_ConvertBSTtoGreaterTree;

// https://leetcode.com/problems/convert-bst-to-greater-tree/
public class Solution {
	// https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488101&idx=1&sn=6041ddda5f20ccde8a7036d3e3a1482c&chksm=9bd7ec6daca0657b2ab20a936437e2c8206384c3b1485fe91747ad796fa3a5b08556b2f4911e&scene=178&cur_album_id=1318896187793260544#rd
	int sum = 0;
	public TreeNode convertBST(TreeNode root) {
		traverse(root);
		return root;
	}
	
	private void traverse(TreeNode root){
		if(root == null){
			return;
		}
		
		traverse(root.right);
		sum += root.val;
		root.val = sum;
		traverse(root.left);
	}

}
