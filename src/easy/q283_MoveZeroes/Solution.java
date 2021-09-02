package easy.q283_MoveZeroes;

/**
 * @author Todd
 *
 *https://leetcode.com/problems/move-zeroes/
 * 1.所有可能解法
 * a.暴力法-->2個loop、count zero
 * b.開一個新的array
 * c.index
 * 2.看別人的解法、空間換時間
 * 3.分析時間、空間複雜度
 * 4.五毒神掌 
 */
public class Solution {
	public static void main(String[] args) {
		
	}
	
	public static void moveZeroes(int[] nums) {
		int totalZeroCount = 0;
		int slowIndex = 0;
		for(int num :nums) {
			if(num != 0) {
				nums[slowIndex] = num;
				slowIndex++;
			}else {
				totalZeroCount++;
			}
		}
		
		for(int i = 0; i < totalZeroCount; i++) {
			nums[nums.length - 1 - i] = 0;
		}
		
	}
}
