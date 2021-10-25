package easy.q171_ExcelSheetColumnNumber;

// https://leetcode.com/problems/excel-sheet-column-number/submissions/
public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().titleToNumber("AB"));
		Integer i = 19;
	}
	
	public int titleToNumber(String columnTitle) {
		int ans = 0;
		for(int i = 0; i < columnTitle.length(); i++){
			ans = ans * 26 + (columnTitle.charAt(i) - 'A') + 1;
		}
		return ans;
	}

}
