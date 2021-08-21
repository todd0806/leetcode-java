package easy.q014_LongestCommonPrefix;

//https://leetcode.com/problems/longest-common-prefix/
public class Solution {
	
	public static void main(String[] args) {
//		System.out.print("test");
		String[] strs = {"flower","flow","flight"};
		System.out.print(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		String pre = strs[0];
		Integer i = 1;
		while( i  < strs.length) {
			while(!strs[i].startsWith(pre)) {
				pre = pre.substring(0, pre.length() - 1);
			}
			i++;
		}
		
		return pre;
    }

}
