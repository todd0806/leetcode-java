package hard.q188_BestTimetoBuyandSellStockIV;

/**
 * @author Todd
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Solution {

	/**https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/javayi-ge-si-lu-da-bao-suo-you-gu-piao-t-pd1p/
	 * https://www.cnblogs.com/hanyuhuang/p/11083384.html
	 * dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
	 * dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
	 *  
	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		int n = prices.length;
		
		if(k > prices.length / 2) {
			return maxProfit_infinity(prices);
		}
		
		int[][][] dp=new int[n][k + 1][2];
		for(int fk = 0; fk <= k; fk++) {
			dp[0][fk][0] = 0;
			dp[0][fk][1] = -prices[0];
		}
		for(int i = 1; i < n; i++) {
			for(int fk = 1; fk <= k; fk++) {
				dp[i][fk][0] = Math.max(dp[i - 1][fk][0], dp[i - 1][fk][1] + prices[i]);
				dp[i][fk][1] = Math.max(dp[i - 1][fk][1], dp[i - 1][fk - 1][0] - prices[i]);
			}
		}
		return dp[n - 1][k][0];
	}
	
	private int maxProfit_infinity(int[] prices) {
		int result = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > prices[i - 1]) {
				result += prices[i] - prices[i - 1];
			}
		}
		return result;
	}

		
}
