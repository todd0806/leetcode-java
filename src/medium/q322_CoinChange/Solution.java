package medium.q322_CoinChange;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Todd https://leetcode.com/problems/coin-change/description/
 */
public class Solution {

	public static void main(String[] argus) {
		System.out.println("" + 
//		new Solution().coinChange(new int[]{1, 2, 5}, 11)
//		new Solution().coinChange(new int[]{2}, 3)
//		new Solution().coinChange(new int[]{186,419,83,408}, 6249)
		new Solution().coinChange(new int[]{1}, 0)
		);
	}
	
	/**DP
	 * https://leetcode-cn.com/problems/coin-change/solution/zi-di-xiang-shang-dong-tai-gui-hua-by-pendygg/
	 * 复杂度分析：
	         时间复杂度：O(N×amount)，这里 N 是可选硬币的种类数，amount是题目输入的面值；
	         空间复杂度：O(amount)，状态数组的大小为 amount
	 * @param coins
	 * @param amount
	 * @return
	 */
//	public int coinChange(int[] coins, int amount) {
//		int[] dp = new int[amount + 1];
//		Arrays.fill(dp, amount + 1);
//		dp[0] = 0;
//		for(int i = 1; i <= amount; i++) {
//			for(int coin : coins) {
//				if(i >= coin) {
//					dp[i] = Math.min(1 + dp[i - coin], dp[i]);
//				}
//			}
//		}
//		dp[amount] = dp[amount] == amount + 1 ? -1 : dp[amount];
//		return dp[amount];
//	}
	
	/**DFS
	 * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
	 * 复杂度分析：
	         时间复杂度：O(N×amount)，这里 N 是可选硬币的种类数，amount是题目输入的面值；
	         空间复杂度：O(amount)，状态数组的大小为 amount
	 * @param coins
	 * @param amount
	 * @return
	 */
//	int[] cache;
//	public int coinChange(int[] coins, int amount) {
//		cache = new int[amount + 1];
//		Arrays.fill(cache, Integer.MAX_VALUE);
//		Arrays.sort(coins);
//		return dfs(coins, amount);
//	}
//	
//	private int dfs(int[] coints, int amount) {
//		// 找不到解
//		if(amount < 0) {
//			return -1;
//		}
//		
//		// 不需要再找
//		if(amount == 0) {
//			return 0;
//		}
//		
//		if(cache[amount] != Integer.MAX_VALUE) {
//			return cache[amount];
//		}
//		
//		for(int coin: coints) {
//			if(amount >= coin) {
//				int res = dfs(coints, amount - coin);
//				// result != -1代表有繼續拆下去的解法
//				if(res != -1 && res + 1 < cache[amount]) {
//					cache[amount] = res + 1;
//				}
//			}
//		}
//		
//		cache[amount] = cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
//		return cache[amount];
//	}
	
	/**BFS
	 * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		if(amount == 0) {
			return 0;
		}
		
		boolean[] visisted = new boolean[amount + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(amount);
		int step = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int head = queue.poll();
				for(int coin: coins) {
					int next = head - coin;
					if(next == 0) {
						return step + 1;
					}
					
					if(next < 0) {
						continue;
					}
					
					if(!visisted[next]) {
						queue.offer(next);
						visisted[next] = true;
					}
				}
			}
			
			step++;
		}
		return -1;
	}

}
