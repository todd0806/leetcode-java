package easy.q191_Numberof1Bits;

/**
 * @author Todd
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class Solution {
	
	/** n & (n - 1)
	 * https://leetcode-cn.com/problems/number-of-1-bits/solution/fu-xue-ming-zhu-xiang-jie-wei-yun-suan-f-ci7i/
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	
	/**暴力法
	 *  算术右移 >>  ：舍弃最低位，高位用符号位填补；
		逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
	 * @param n
	 * @return
	 */
//	public int hammingWeight(int n) {
//		int count = 0;
//		while (n != 0) {
//			count += n & 1;
//			n = n >>> 1;
//		}
//		
////		for (int i = 0; i < 32; i++) {
////			count += (n >>> i) & 1;
////		}
//		return count;
//	}
}
