package easy.q121_BestTimetoBuyandSellStock;

/**
 * @author Todd https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution {
	
	public static void main(String[] args) {
		int[] prices = new int[] {7,1,5,3,6,4};
		System.out.print(new Solution().maxProfit(prices));
	}
	
	
	/**https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39062/My-jave-accepted-solution-with-O(N)-time-and-O(1)-space
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2) {
			return 0;
		}
		
		int min = prices[0];
		int max = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
			}else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}
}
