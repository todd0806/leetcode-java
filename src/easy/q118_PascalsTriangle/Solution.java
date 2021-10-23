package easy.q118_PascalsTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/

public class Solution {
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> generate(int numRows) {
		ans.add(Arrays.asList(1));
		if (numRows == 1) {
			return ans;
		}

		for (int i = 2; i <= numRows; i++) {
			List<Integer> rowList = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				if (j == 0) {
					rowList.add(1);
					continue;
				}

				if (j == i - 1) {
					rowList.add(1);
					continue;
				}

				rowList.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
			}
			ans.add(rowList);
		}
		return ans;
	}
}
