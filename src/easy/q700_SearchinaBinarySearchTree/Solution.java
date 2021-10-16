package easy.q700_SearchinaBinarySearchTree;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class Solution {
	
	// https://leetcode-cn.com/problems/search-in-a-binary-search-tree/solution/er-cha-sou-suo-shu-zhong-de-sou-suo-java-wskj/
	
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}

		if (root.val > val) {
			return searchBST(root.left, val);
		} else if (root.val < val) {
			return searchBST(root.right, val);
		} else {
			return root;
		}
	}

//	public TreeNode searchBST(TreeNode root, int val) {
//		if (root == null) {
//			return null;
//		}
//
//		while (root != null) {
//			if (root.val > val) {
//				root = root.left;
//			} else if (root.val < val) {
//				root = root.right;
//			} else {
//				return root;
//			}
//		}
//
//		return null;
//	}

}
