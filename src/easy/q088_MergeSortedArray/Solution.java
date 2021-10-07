package easy.q088_MergeSortedArray;

//https://leetcode.com/problems/merge-sorted-array/
public class Solution {
	/**https://leetcode-cn.com/problems/merge-sorted-array/solution/wa-pian-88he-bing-liang-ge-you-xu-shu-zu-f9g5/
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index1 = m - 1;
		int index2 = n - 1;
		int valueIndex = nums1.length - 1;
		while (index1 >= 0 && index2 >= 0) {
			if (nums1[index1] > nums2[index2]) {
				nums1[valueIndex--] = nums1[index1--];
			} else {
				nums1[valueIndex--] = nums2[index2--];
			}
		}

		while (index1 >= 0) {
			nums1[valueIndex--] = nums1[index1--];
		}

		while (index2 >= 0) {
			nums1[valueIndex--] = nums2[index2--];
		}
	}
}
