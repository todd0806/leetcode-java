package hard.q076_MinimumWindowSubstring;

import java.util.HashMap;

/**
 * @author Todd
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class Solution {
	public static void main(String[] args) {
		
		int[] map = new int[2];
		map[0] = 1;
		map[1] = 2;
		int right = 0;
		if(map[right++]++ > 1) {
			System.out.print("1");
		}else {
			System.out.print("2");
		}
		
		System.out.print(
//				new Solution().minWindow("ADOBECODEBANC", "ABC")
//				new Solution().minWindow("a", "aa")
				new Solution().minWindow("aaflslflsldkalskaaa", "aaa")
		);
	}
	
	/**精簡版
	 * https://leetcode-cn.com/problems/minimum-window-substring/solution/shu-ju-jie-gou-he-suan-fa-hua-dong-chuan-p6ip/
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
		int[] map = new int[128];
		// 记录字符串t中每个字符的数量
		for (char ch : t.toCharArray())
			map[ch]++;
		// 字符串t的数量
		int count = t.length();
		int left = 0;// 窗口的左边界
		int right = 0;// 窗口的右边界
		// 覆盖t的最小长度
		int windowLength = Integer.MAX_VALUE;
		// 覆盖字符串t开始的位置
		int strStart = 0;
		while (right < s.length()) {
			if (map[s.charAt(right++)]-- > 0)
				count--;
			// 如果全部覆盖
			while (count == 0) {
				// 如果有更小的窗口就记录更小的窗口
				if (right - left < windowLength) {
					windowLength = right - left;
					strStart = left;
				}
				// 走到這，不符合需要的map[x]應該都是負的了
				if (map[s.charAt(left++)]++ == 0)
					count++;
			}
		}
		// 如果找到合适的窗口就截取，否则就返回空
		if (windowLength != Integer.MAX_VALUE)
			return s.substring(strStart, strStart + windowLength);
		return "";
	}

	/**https://leetcode-cn.com/problems/minimum-window-substring/solution/shu-ju-jie-gou-he-suan-fa-hua-dong-chuan-p6ip/
	 * 動畫說明
	 * 此解是初版，較完整說明
	 * @param s
	 * @param t
	 * @return
	 */
//	public String minWindow(String s, String t) {
//		if(t.length() > s.length()) {
//			return "";
//		}
//		
//		HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();
//		HashMap<Character, Integer> window = new HashMap<Character, Integer>();
//		for(char c: t.toCharArray()) {
//			targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
//		}
//		
//		int right = 0;
//		int minWindowLength = Integer.MAX_VALUE;
//		int minStart = 0;
//		int left = 0;
//		int count = 0;
//		
//		while(right < s.length()) {
//			char r = s.charAt(right);
//			if(targetMap.containsKey(r)) {
//				window.put(r, window.getOrDefault(r, 0) + 1);
//				// 湊好的char數量
//				// 關鍵：要用equals
//				if(window.get(r).equals(targetMap.get(r))) {
//					count++;
//				}
//			}
//			
//			while(count == targetMap.size()) {
//				if(right - left < minWindowLength) {
//					minWindowLength = right - left + 1;
//					minStart = left;
//				}
//				char l = s.charAt(left);
//				if(targetMap.containsKey(l)) {
//					window.put(l, window.get(l) - 1);
//					// 關鍵行，要用<，不能用!=
//					if(window.get(l) < targetMap.get(l)) {
//						count--;
//					}
//				}
//				left++;
//			}
//			right++;
//		}
//		
//		return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minWindowLength);
//	}
}
