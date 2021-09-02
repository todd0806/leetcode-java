package hard.q084_LargestRectangleInHistogram;

import java.util.Stack;

/**
 * @author Todd
 *https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * 暴力法圖解如下：
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 * 
 * 參考解法：
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/dong-hua-yan-shi-dan-diao-zhan-84zhu-zhu-03w3/
 */
public class Solution {

	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		int len = heights.length;
		for(int i = 0; i <= len; ) {
			int h = i == len ? 0 : heights[i];
			if(stack.empty() || h >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			}else {
				int curHeight = heights[stack.pop()];
				int rightBoundary = i - 1;
				int leftBoundary= stack.peek();
				maxArea = Math.max(maxArea, (rightBoundary - leftBoundary + 1) * curHeight);
			}
		}
		return maxArea;
	}
	
	/**參考解法
	 * @param heights
	 * @return
	 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
	 */
//	public int largestRectangleArea(int[] heights) {
//		int len = heights.length;
//		int maxArea = 0;
//		Stack<Integer> stack = new Stack<>();
//		for (int i = 0; i <= len;) {
//			int h = (i == len ? 0 : heights[i]);
//			if (stack.isEmpty() || h >= heights[stack.peek()]) {
//				stack.push(i);
//				i++;
//			} else {
//				int curHeight = heights[stack.pop()];
//				int rightBoundary = i - 1;
//				int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
//				int width = rightBoundary - leftBoundary + 1;
//				maxArea = Math.max(maxArea, (curHeight * width));
//			}
//		}
//		return maxArea;
//	}
	
}
