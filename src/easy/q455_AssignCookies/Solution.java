package easy.q455_AssignCookies;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/description/

/**
 * @author	Todd
 * @date	2021/8/25
 * 思路：貪心思想
 * 注意：小心2個array的初始檢查，與塞餅乾時的index邊界狀況
 */
public class Solution {

	public static void main(String[] args) {
		int[] greed = { 1, 2, 3 };
		int[] cookie = { 1, 1 };
		System.out.print(new Solution().findContentChildren(greed, cookie));
	}
	
	public int findContentChildren(int[] greed, int[] cookie) {
		if(greed == null || greed.length == 0 || cookie == null || cookie.length == 0) {
			return 0;
		}
		
		Arrays.sort(greed);
		Arrays.sort(cookie);
		int content = 0;
		int cookieIndex = cookie.length - 1;
		int greedIndex = greed.length - 1;
		while(greedIndex >= 0 && cookieIndex >= 0) {
			if(cookie[cookieIndex] >= greed[greedIndex]) {
				content ++;
				cookieIndex--;
				greedIndex--;
			}else {
				greedIndex--;
			}
		}
		return content;
	}
	
	
//	public static int findContentChildren(int[] greed, int[] cookie) {
//		if(greed == null || greed.length == 0) {
//			return 0;
//		}
//		
//		if(cookie == null || cookie.length == 0) {
//			return 0;
//		}
//		
//		Arrays.sort(greed);
//		Arrays.sort(cookie);
//		int satisfyiedChildren = 0;
//		int cookieIndex = 0;
//		while(cookieIndex < cookie.length && satisfyiedChildren < greed.length) {
//			if(cookie[cookieIndex] >= greed[satisfyiedChildren]) {
//				satisfyiedChildren++;
//			}
//			cookieIndex++;
//		}
//		return satisfyiedChildren;
//	}
}
