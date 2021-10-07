package easy.q338_CountingBits;

/**
 * @author Todd
 * https://leetcode.com/problems/counting-bits/
 */
public class Solution {
	
	/**DP
	 * https://leetcode-cn.com/problems/counting-bits/solution/po-su-jie-fa-dong-tai-gui-hua-jie-fa-by-vvail/
	 * @param n
	 * @return
	 */
	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		ans[0] = 0;
		for(int i = 1; i <= n; i++) {
			ans[i] = ans[i >> 1] + (i & 1);
		}
		return ans;
	}
	
	/**暴力法
	 * @param n
	 * @return
	 */
//	public int[] countBits(int n) {
//		int[] ans = new int[n + 1];
//		for(int i = 0; i <= n; i++) {
//			int count = 0;
//			for(int j = 0; j < 32; j++) {
//				count += (i >> j) & 1;
//			}
//			ans[i] = count;
//		}
//		return ans;
//	}
}
