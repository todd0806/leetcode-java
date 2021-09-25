package medium.q122_BestTimetoBuyandSellStockII;

/**
 * @author Todd
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Solution {
	public static void main(String[] args) {
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.print(new Solution().maxProfit(prices));
	}
	
	/**DP(K infinity)
	 * dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
	 * dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
	 *             = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
	 * 簡化
	 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
	 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
	 * 
	 * @param prices
	 * @return
	 */
//	public int maxProfit(int[] prices) {
//		if(prices == null || prices.length <= 1) {
//			return 0;
//		}
//		int n = prices.length; 
//		int[][] dp = new int[n][2];
//		dp[0][0] = 0;
//		dp[0][1] = -prices[0];
//		for(int i = 1; i < n; i++) {
//			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//		}
//		
//		return dp[n - 1][0];
//	}
	
	// 優化空間
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		int n = prices.length; 
		int[]dp = new int[2];
		dp[0] = 0;
		dp[1] = -prices[0];
		for(int i = 1; i < n; i++) {
			int temp = dp[0];
			dp[0] = Math.max(dp[0], dp[1] + prices[i]);
			dp[1] = Math.max(dp[1], temp - prices[i]);
		}
		
		return dp[0];
	}
	
	/**
	 * @param prices
	 * @return
	 */
//	public int maxProfit(int[] prices) {
//		if(prices == null || prices.length < 2) {
//			return 0;
//		}
//		
//		int max = 0;
//		for(int i = 1; i < prices.length; i++) {
//			if(prices[i] > prices[i - 1]) {
//				max += prices[i] - prices[i - 1];
//			}
//		}
//		return max;
//	}
}
