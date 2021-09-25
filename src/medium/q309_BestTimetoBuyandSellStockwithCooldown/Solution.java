package medium.q309_BestTimetoBuyandSellStockwithCooldown;

/**
 * @author Todd
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Solution {
	
	/**https://www.cnblogs.com/hanyuhuang/p/11083384.html
	 * dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
	 * dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 2][k - 1][0] - prices[i]);
	 * k is infinity可簡化
	 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
	 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		int n = prices.length;
		int dpi0 = 0;
		int dpi1 = -prices[0];
		int dpPre = 0;	//代表前一天
		for(int i = 1; i < n; i++) {
			int temp = dpi0;
			dpi0 = Math.max(dpi0,  dpi1 + prices[i]);
			dpi1 = Math.max(dpi1,  dpPre - prices[i]);
			dpPre = temp;
		}
		return dpi0;
	}
}
