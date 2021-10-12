package medium.q105_ConstructBinaryTreefromPreorderandInorderTraversal;

import java.util.Arrays;

/**
 * @author Todd
 *         https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {
	// https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487270&idx=1&sn=2f7ad74aabc88b53d94012ceccbe51be&chksm=9bd7f12eaca078384733168971147866c140496cb257946f8170f05e46d16099f3eef98d39d9&scene=178&cur_album_id=1318896187793260544#rd

	public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd) {
			return null;
		}

		// root 节点对应的值就是前序遍历数组的第一个元素
		int rootVal = preorder[preStart];
		// rootVal 在中序遍历数组中的索引
		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == rootVal) {
				index = i;
				break;
			}
		}

		int leftSize = index - inStart;

		// 先构造出当前根节点
		TreeNode root = new TreeNode(rootVal);
		// 递归构造左右子树
		root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);

		root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
		return root;
	}

	/**
	 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/dong-hua-yan-shi-105-cong-qian-xu-yu-zhong-xu-bian/
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
//	public TreeNode buildTree(int[] preorder, int[] inorder) {
//		if(preorder.length == 0 || inorder.length == 0) {
//			return null;
//		}
//		
//		// 前序的第一個元素是根節點
//		TreeNode root = new TreeNode(preorder[0]);
//		for(int i = 0; i < inorder.length; i++) {
//			// 中序的中間元素為根節點
//			if(preorder[0] == inorder[i]) {
//				int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
//				int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
//				int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
//				int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
//				root.left = buildTree(preLeft, inLeft);
//				root.right = buildTree(preRight, inRight);
//				break;
//			}
//		}
//		
//		return root;
//	}
}
