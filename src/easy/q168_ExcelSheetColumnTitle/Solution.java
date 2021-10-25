package easy.q168_ExcelSheetColumnTitle;

// https://leetcode.com/problems/excel-sheet-column-title/ 
public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().convertToTitle(701));
	}

	public String convertToTitle(int columnNumber) {
		int n = columnNumber;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.insert(0, (char) ('A' + (n % 26)));
			n /= 26;
		}
		return sb.toString();
	}
}
