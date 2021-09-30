package medium.q621_TaskScheduler;

/**
 * @author Todd https://leetcode.com/problems/task-scheduler/
 */
public class Solution {
	public static void main(String[] args) {
		System.out.print(
//			new Solution().leastInterval( "AAABBB".toCharArray(), 2)
			new Solution().leastInterval( "AAABBB".toCharArray(), 0)
		);
	}
	
	/**https://leetcode-cn.com/problems/task-scheduler/solution/tian-tong-si-lu-you-tu-kan-wan-jiu-dong-by-mei-jia/
	 * https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
	 * @param tasks
	 * @param n
	 * @return
	 */
	private int leastInterval(char[] tasks, int n) {
		int[] charCount = new int[26];
		int maxCharCount = 0;
		for(char c: tasks) {
			charCount[c - 'A']++;
			maxCharCount = Math.max(maxCharCount, charCount[c-'A']);
		}
		
		int leftCharCount = 0;
		for(int i = 0; i < 26; i++) {
			if(charCount[i] == maxCharCount) {
				leftCharCount++;
			}
		}
		return Math.max((maxCharCount - 1) * (n + 1) + leftCharCount, tasks.length);
	}
}
