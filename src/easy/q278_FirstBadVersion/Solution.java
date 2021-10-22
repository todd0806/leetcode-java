package easy.q278_FirstBadVersion;

//https://leetcode.com/problems/first-bad-version/ 

public class Solution {
	
	// 參考Leeetcode 34題寫
	public int firstBadVersion(int n) {
		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (isBadVersion(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	// dummy code
	private boolean isBadVersion(int n) {
		return true;
	}
}
