package medium.q714_BestTimetoBuyandSellStockwithTransactionFee;

/**
 * @author Todd
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class Solution {
	
	/**https://www.cnblogs.com/hanyuhuang/p/11083384.html
	 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/javayi-ge-si-lu-da-bao-suo-you-gu-piao-t-pd1p/
	 * //卖出股票时完成一次交易，支付手续费
	 * dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i] - fee);
	 * dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
	 * @param prices
	 * @param fee
	 * @return
	 */
	public int maxProfit(int[] prices, int fee) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		int n = prices.length;
		int dpi0 = 0;
		int dpi1 = -prices[0];
		for(int i = 1; i < n; i++) {
			int temp = dpi0;
			dpi0 = Math.max(dpi0, dpi1 + prices[i] - fee);
			dpi1 = Math.max(dpi1, temp - prices[i]);
		}
		return dpi0;
	}
}
