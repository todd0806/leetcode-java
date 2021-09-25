package easy.q121_BestTimetoBuyandSellStock;

/**
 * @author Todd https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution {
	
	public static void main(String[] args) {
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.print(new Solution().maxProfit(prices));
	}
	
	/**DP(K = 1)
	 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/qian-duan-shi-tang-ti-jie-chao-hao-li-ji-gpb4/
	 * dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
	 * dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
	 * k = 1簡化
	 * dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i])
	 * dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i])
	 * 再簡化
	 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
	 * dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i])
	 * 
	 * @param prices
	 * @return
	 */
//	private int maxProfit(int[] prices) {
//		if(prices == null || prices.length <= 1) {
//			return 0;
//		}
//		
//		int n = prices.length;
//		int[][] dp = new int[n][2];
//		dp[0][0] = 0;
//		dp[0][1] = -prices[0];
//		for(int i = 1; i < n; i++) {
//			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//			dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
//		}
//		return dp[n - 1][0];
//	}

	//優化空間
	private int maxProfit(int[] prices) {
		if(prices == null || prices.length <= 1) {
			return 0;
		}
		
		int n = prices.length;
		int[] dp = new int[2];
		dp[0] = 0;
		dp[1] = -prices[0];
		for(int i = 1; i < n; i++) {
			dp[0] = Math.max(dp[0], dp[1] + prices[i]);
			dp[1] = Math.max(dp[1], 0 - prices[i]);
		}
		return dp[0];
	}
	
//	https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/fu-xi-gu-piao-wen-ti-zhuang-tai-dpyi-chong-fang-fa/
//	private int maxProfit(int[] prices) {
//		int max = 0;
//		// 特判
//		if (prices.length <= 1) {
//			return max;
//		}
//		int min = prices[0];
//		// 遍历每一天的股票，如果今天卖的话，只要找到前几天最低的股票价格买入即可
//		for (int i = 1; i < prices.length; i++) {
//			max = Math.max(prices[i] - min, max);
//			min = Math.min(min, prices[i]);
//		}
//		return max;
//	}

	
	/**https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39062/My-jave-accepted-solution-with-O(N)-time-and-O(1)-space
	 * @param prices
	 * @return
	 */
//	public int maxProfit(int[] prices) {
//		if(prices == null || prices.length < 2) {
//			return 0;
//		}
//		
//		int min = prices[0];
//		int max = 0;
//		for(int i = 1; i < prices.length; i++) {
//			if(prices[i] < min) {
//				min = prices[i];
//			}else {
//				max = Math.max(max, prices[i] - min);
//			}
//		}
//		return max;
//	}
}
