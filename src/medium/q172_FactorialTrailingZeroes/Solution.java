package medium.q172_FactorialTrailingZeroes;
// https://leetcode.com/problems/factorial-trailing-zeroes/
public class Solution {
	
	// https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52367/My-explanation-of-the-Log(n)-solution
	
	public int trailingZeroes(int n) {
		int count = 0;
		while (n > 0) {
			count += n / 5;
			n = n / 5;
		}
		return count;
	}
}
