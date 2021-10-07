package hard.q084_LargestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Todd
 *https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * 暴力法圖解如下：
 * 
 * 
 * 參考解法：
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/dong-hua-yan-shi-dan-diao-zhan-84zhu-zhu-03w3/
 */
public class Solution {

//	https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
	public int largestRectangleArea(int[] heights) {
		if(heights.length == 1 && heights[0] == 0) {
			return 0;
		}
		int[] newHeights = new int[heights.length + 2];
		System.arraycopy(heights, 0, newHeights, 1, heights.length);
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);
		int ans = 0;
		for(int i = 1; i < newHeights.length; i++) {
			while(newHeights[i] < newHeights[stack.peekLast()]) {
				int curHeight = newHeights[stack.pollLast()];
				int curWidth = i - stack.peekLast() - 1;
				ans = Math.max(ans, curHeight * curWidth);
			}
			stack.addLast(i);
		}
		return ans;
	}
		
	
//	public int largestRectangleArea(int[] heights) {
//		int maxArea = 0;
//		Stack<Integer> stack = new Stack<>();
//		int len = heights.length;
//		for(int i = 0; i <= len; ) {
//			int h = i == len ? 0 : heights[i];
//			if(stack.empty() || h >= heights[stack.peek()]) {
//				stack.push(i);
//				i++;
//			}else {
//				int curHeight = heights[stack.pop()];
//				int rightBoundary = i - 1;
//				int leftBoundary= stack.peek();
//				maxArea = Math.max(maxArea, (rightBoundary - leftBoundary + 1) * curHeight);
//			}
//		}
//		return maxArea;
//	}
	
}
