package medium.q074_Searcha2DMatrix;

/**
 * @author Todd
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Solution {
	
	public static void main(String[] args) {
		System.out.print("" +
//		new Solution().searchMatrix(new int[][] {{1}}, 1)
//		new Solution().searchMatrix(new int[][] {{1}, {3}, {5}}, 3) 
		new Solution().searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 11)
		);
	}
	
	//https://leetcode-cn.com/problems/search-a-2d-matrix/solution/fu-xue-ming-zhu-liu-chong-fang-fa-bang-n-e20z/
	
	/**方法三：列二分 + 行二分
	 * O(log(M) + log(N))
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		if(target < matrix[0][0] || target > matrix[rowCount - 1][columnCount - 1]) {
			return false;
		}else if(target == matrix[0][0] || target == matrix[rowCount - 1][columnCount - 1]){
			return true;
		}	
		
		// 1st find whilch row
		int left = 0; 
		int right = rowCount - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(target == matrix[mid][0]) {
				return true;
			}else if(target < matrix[mid][0]) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		// key!!!!
		int selectedRow = left - 1;
		
		// 2nd find target in selected row
		left = 0;
		right = columnCount - 1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(target == matrix[selectedRow][mid]) {
				return true;
			}else if (target < matrix[selectedRow][mid]) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return false;
	}
	
	/**方法二：从左下角或者右上角开始查找，再二分
	 * O(M+log(N))
	 * @param matrix
	 * @param target
	 * @return
	 */
//	public boolean searchMatrix(int[][] matrix, int target) {
//		int rowCount = matrix.length;
//		int columnCount = matrix[0].length;
//		if(target < matrix[0][0] || target > matrix[rowCount - 1][columnCount - 1]) {
//			return false;
//		}else if(target == matrix[0][0] || target == matrix[rowCount - 1][columnCount - 1]){
//			return true;
//		}		
//		
//		int findRow = rowCount - 1;
//		while(target < matrix[findRow][0]) {
//			findRow--;
//		}
//		
//		int left = 0;
//		int right = columnCount - 1;
//		while(left <= right) {
//			int mid = left + (right - left) / 2;
//			if(target == matrix[findRow][mid]) {
//				return true;
//			}else if(target < matrix[findRow][mid]) {
//				right = mid - 1;
//			}else {
//				left = mid + 1;
//			}
//		}
//		
//		return false;
//	}
	
	/**暴力法 O(M*N)
	 * @param matrix
	 * @param target
	 * @return
	 */
//	public boolean searchMatrix(int[][] matrix, int target) {
//		for(int i = 0; i < matrix.length; i++) {
//			for(int j = 0; j < matrix[0].length; j++) {
//				if(target == matrix[i][j]) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	
}
