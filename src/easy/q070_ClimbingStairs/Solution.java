package easy.q070_ClimbingStairs;

import java.util.HashMap;

/**
 * @author Todd
 *https://leetcode.com/problems/climbing-stairs/
 *思路：找最近重複子問題
 */
public class Solution {

	public static void main(String[] args) {
		System.out.print(climbStairs(45));
	}

	/**只存最近3個結果，優化空間複雜度
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		if(n <= 2) {
			return n;
		}

		int fn2 = 1;	// f(n-2)
		int fn1 = 2;	// f(n-1)
		int fn = 3;		// f(n) = f(n-1) + f(n-2)
		for(int i = 3; i <= n; i++) {
			fn = fn1 + fn2;
			fn2 = fn1;
			fn1 = fn;
		}
		return fn;
	}
	
	/**用map緩存所有的結果
	 * @param n
	 * @return
	 */
//	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//	public static int climbStairs(int n) {
//		if(n == 1) {
//			return 1;
//		}else if (n == 2) {
//			return 2;
//		}else if(n > 2){
//			if(map.containsKey(n)) {
//				return map.get(n);
//			}else {
//				map.put(n, climbStairs(n-1) + climbStairs(n-2));
//				return map.get(n);
//			}
//		}else {
//			return 0;
//		}
//	}
}
