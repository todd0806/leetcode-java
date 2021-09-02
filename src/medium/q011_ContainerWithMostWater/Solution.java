package medium.q011_ContainerWithMostWater;

/**
 * @author Todd
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * 1.所有可能解法
 * a.暴力法-->left bar, right bar, (x-y)*height---->O(n^2)
 * b.開一個新的array
 * c.index
 * 2.看別人的解法
 * 3.分析時間、空間複雜度
 * 4.五毒神掌 
 */
public class Solution {

	/**while 寫法
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while(left < right) {
			int minHeight = Math.min(height[left], height[right]);
			max = Math.max(max, (right - left) * minHeight);
			if(height[left] < height[right]) {
				left++;
			}else {
				right--;
			}
		}
		return max;
	}
	
	/**for 迴圈寫法
	 * @param height
	 * @return
	 */
//	public int maxArea(int[] height) {
//		int max = 0;
//		for(int i = 0, j = height.length -1; i < j; ) {
//			int minHeight = height[i] < height[j] ? height[i++] : height[j--];
//			int area = (j - i + 1) * minHeight;
//			max = Math.max(area, max);
//		}
//		return max;
//	}
	
	/**暴力法求解-->submit-->Time Limit Exceeded
	 * @param height
	 * @return
	 */
//	public int maxArea(int[] height) {
//		int maxArea = 0;
//		for(int i = 0; i < height.length -1; i++) {
//			for(int j = i + 1; j < height.length; j++) {
//				int area = (j - i) * Math.min(height[i], height[j]);
//				maxArea = Math.max(area, maxArea);
//			}
//		}
//		return maxArea;
//	}
}
