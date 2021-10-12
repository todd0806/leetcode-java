package medium.q106_ConstructBinaryTree;

public class Solution {
	//https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487270&idx=1&sn=2f7ad74aabc88b53d94012ceccbe51be&chksm=9bd7f12eaca078384733168971147866c140496cb257946f8170f05e46d16099f3eef98d39d9&scene=178&cur_album_id=1318896187793260544#rd
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postEnd]);
		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				index = i;
				break;
			}
		}

		int leftSize = index - inStart;

		root.left = build(inorder, inStart, inStart + leftSize - 1, postorder, postStart, postStart + leftSize - 1);
		root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
		return root;
	}
}
