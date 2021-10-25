package easy.q283_MoveZeroes;

/**
 * @author Todd
 *
 *         https://leetcode.com/problems/move-zeroes/ 1.所有可能解法
 *         a.暴力法-->2個loop、count zero b.開一個新的array c.index 2.看別人的解法、空間換時間
 *         3.分析時間、空間複雜度 4.五毒神掌
 */
public class Solution {

	public static void moveZeroes(int[] nums) {
		if (nums.length <= 1) {
			return;
		}

		int zeroCount = 0;
		int dataIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[dataIndex++] = nums[i];
			} else {
				zeroCount++;
			}
		}

		for (int i = nums.length - zeroCount; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
