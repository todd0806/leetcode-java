package easy.q122_BestTimetoBuyandSellStockII;

/**
 * @author Todd
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Solution {
	public static void main(String[] args) {
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.print(new Solution().maxProfit(prices));
	}
	
	/**
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2) {
			return 0;
		}
		
		int max = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > prices[i - 1]) {
				max += prices[i] - prices[i - 1];
			}
		}
		return max;
	}
}
