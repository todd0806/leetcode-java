package easy.q231_PowerofTwo;

/**
 * @author Todd
 * https://leetcode.com/problems/power-of-two/
 */
public class Solution {
	/**技巧：n & (n - 1)-->移掉最近的一個1
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo(int n) {
		int newN = n & (n - 1);
		if (n > 0 && (newN == 0)) {
			return true;
		} else {
			return false;
		}
	}
}
