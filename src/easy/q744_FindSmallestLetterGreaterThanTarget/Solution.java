package easy.q744_FindSmallestLetterGreaterThanTarget;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class Solution {
	// https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/solution/java-zi-fu-chuan-bian-li-by-jonnyhuang-gieq/
	// 全掃過
	public char nextGreatestLetter(char[] letters, char target) {
		for (char c : letters) {
			if (c > target) {
				return c;
			}
		}
		return letters[0];
	}
}
