package hard.q297_SerializeAndDeserializeBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Todd
 *https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */

// 圖解：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/shou-hui-tu-jie-gei-chu-dfshe-bfsliang-chong-jie-f/
// 參考(第二個人寫的)：https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution

//Your Codec object will be instantiated and called as such:
//Codec ser = new Codec();
//Codec deser = new Codec();
//TreeNode ans = deser.deserialize(ser.serialize(root));

public class Codec {
	private final static String SEPARATOR = ",";
	private final static String NULL_POINTER = "#";
	
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return serialize(new StringBuilder(), root).toString();
	}
	
	private StringBuilder serialize(StringBuilder sb, TreeNode node) {
		if(node == null) {
			return sb.append(NULL_POINTER);
		}
		sb.append(node.val).append(SEPARATOR);
		serialize(sb, node.left).append(SEPARATOR);
		serialize(sb, node.right);
		return sb;
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return buildTree(new LinkedList<>(Arrays.asList(data.split(SEPARATOR))));
	}
	
	private TreeNode buildTree(Deque<String> deque) {
		String s = deque.poll();
		if(s.equals(NULL_POINTER)) {
			return null;
		}
		
		TreeNode node = new TreeNode(Integer.valueOf(s));
		node.left = buildTree(deque);
		node.right = buildTree(deque);
		return node;
	}
}