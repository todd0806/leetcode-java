package medium.q240_Searcha2DMatrixII;

/**
 * @author Todd
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Solution {
	
	/**https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/hua-tu-jie-ti-sou-suo-er-wei-ju-zhen-ii-by-ji-jue-/
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		if(target < matrix[0][0] || target > matrix[rowCount - 1][columnCount - 1]) {
			return false;
		}else if (target == matrix[0][0] || target > matrix[rowCount - 1][columnCount - 1]) {
			return true;
		}
		
		// 從右上或左下都可以，增減對象與邊界條件要配合調整
		int row = 0;
		int column = columnCount - 1;
		while(row < rowCount && column >= 0) {
			if(matrix[row][column] == target) {
				return true;
			}else if(matrix[row][column] < target) {
				row++;
			}else {
				column--;
			}
		}
		return false;
		
	}
}
