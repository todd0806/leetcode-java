package easy.q069_SqrtX;

/**
 * @author Todd
 *https://leetcode.com/problems/sqrtx/
 */
public class Solution {
	
	public static void main(String[] args) {
		new Solution().mySqrt(8);
	}

	//https://leetcode.com/problems/sqrtx/discuss/402730/sqrt(x)-Binary-Search-Solution-with-Explanation
	public int mySqrt(int x) {
		if(x <= 1) {
			return x;
		}
		int left = 0; 
		int right = x / 2;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if((long)mid * mid > x){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return right;
		
	}
	
	/**牛頓迭代
	 * https://leetcode-cn.com/problems/valid-perfect-square/solution/you-xiao-de-wan-quan-ping-fang-shu-by-leetcode/
	 * x = (x + num/x) / 2
	 * @param x
	 * @return
	 */
//	public int mySqrt(int x) {
//		if(x == 0 || x == 1) {
//			return x;
//		}
//		
//		long sqrt = x / 2;
//		while(sqrt * sqrt > x) {
//			sqrt = (sqrt + x/sqrt) / 2;
//		}
//		return (int)sqrt;
//	}
//	
	/**二分查找
	 * https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-fa-7xing-100-by-climite-4ejm/
	 * @param x
	 * @return
	 */
//	public int mySqrt(int x) {
//		if(x == 0 || x == 1) {
//			return x;
//		}
//		
//		int left = 1;
//		int right = x;
//		while(left <= right) {
//			long mid = left + (right - left) / 2;
////			System.out.println(String.format("left:%d right:%d mid:%d", left, right, mid));
//			if(mid * mid == x) {
//				return (int) mid;
//			}else if (mid * mid > x) {
////				System.out.println(String.format("mid * mid > x, new right:%d", ( (int) (mid - 1))));
//				right = (int) (mid - 1);
//			}else {
////				System.out.println(String.format("mid * mid < x, new left:%d", ( (int) (mid + 1))));
//				left = (int) (mid + 1);
//			}
//		}
//		return right;
//	}
}
