package easy.q190_ReverseBits;

/**
 * @author Todd
 * https://leetcode.com/problems/reverse-bits/
 */
public class Solution {
	/**https://leetcode-cn.com/problems/reverse-bits/solution/4chong-jie-jue-fang-shi-tu-wen-xiang-jie-fsgg/
	 * @param n
	 * @return
	 */
	public int reverseBits(int n) {
		int ans = 0;
		for(int i = 0; i < 32; i++) {
			ans = ans << 1;
			ans |= n & 1;
			n = n >> 1;
		}
		return ans;
	}
}
