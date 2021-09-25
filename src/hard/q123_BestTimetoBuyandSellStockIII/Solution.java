package hard.q123_BestTimetoBuyandSellStockIII;

/**
 * @author Todd
	https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Solution {
	public static void main(String[] args) {
		int[] prices = new int[] {3,3,5,0,0,3,1,4};
		System.out.print(new Solution().maxProfit(prices));
	}

	//https://www.cnblogs.com/hanyuhuang/p/11083384.html
	//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/qian-duan-shi-tang-ti-jie-chao-hao-li-ji-gpb4/
//	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/dong-tai-gui-hua-by-liweiwei1419-7/
	
	/**DP(K = 2)
	 * dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
	 * dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
	 * 無法簡化，需遍歷k = 1跟 k = 2
	 * dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
	 * dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
	 * dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
	 * dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
	 * 			   = Math.max(dp[i - 1][1][1], - prices[i]);
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		
		int n = prices.length;
		int dpi10 = 0;
		int dpi11 = -prices[0];
		int dpi20 = 0;
		int dpi21 = -prices[0];
		for (int i = 1; i < n; i++) {
			dpi10 = Math.max(dpi10, dpi11 + prices[i]);
			dpi11 = Math.max(dpi11, -prices[i]);
			dpi20 = Math.max(dpi20, dpi21 + prices[i]);
			dpi21 = Math.max(dpi21, dpi10 - prices[i]);
		}
		return dpi20;
	}
}
