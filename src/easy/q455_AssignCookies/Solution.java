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
		int[] greed = { 1, 2 };
		int[] cookie = { 1, 2, 3 };
		System.out.print(findContentChildren(greed, cookie));
	}
	
	public static int findContentChildren(int[] greed, int[] cookie) {
		if(greed == null || greed.length == 0) {
			return 0;
		}
		
		if(cookie == null || cookie.length == 0) {
			return 0;
		}
		
		Arrays.sort(greed);
		Arrays.sort(cookie);
		int satisfyiedChildren = 0;
		int cookieIndex = 0;
		while(cookieIndex < cookie.length && satisfyiedChildren < greed.length) {
			if(cookie[cookieIndex] >= greed[satisfyiedChildren]) {
				satisfyiedChildren++;
			}
			cookieIndex++;
		}
		return satisfyiedChildren;
	}
}
