package easy.q367_ValidPerfectSquare;

/**
 * @author Todd
 *https://leetcode.com/problems/valid-perfect-square/
 */
public class Solution {
	
	/**牛頓迭代
	 * https://leetcode-cn.com/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-by-leetcode/
	 * x = (x + num/x) / 2;
	 * @param num
	 * @return
	 */
	public boolean isPerfectSquare(int num) {
		if(num < 2) {
			return true;
		}
		
		long x = num / 2;
		while(x * x > num) {
			x = (x + num / x) / 2;
		}
		return x * x == num;
	}
	
	/**二分查找
	 * https://leetcode-cn.com/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-java-ew6uv/
	 * @param num
	 * @return
	 */
//	public boolean isPerfectSquare(int num) {
//		if(num < 2) {
//			return true;
//		}
//		long left = 0; 
//		long right = num / 2;
//		while(left <= right) {
//			long mid = left + (right - left) / 2;
//			if(mid * mid == num) {
//				return true;
//			}else if(mid * mid > num){
//				right = mid - 1;
//			}else {
//				left = mid + 1;
//			}
//		}
//		return false;
//	}
}
