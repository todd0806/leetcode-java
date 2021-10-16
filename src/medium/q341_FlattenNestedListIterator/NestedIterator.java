package medium.q341_FlattenNestedListIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/flatten-nested-list-iterator/
public class NestedIterator implements Iterator<Integer> {

	// https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/yi-ti-shuang-jie-dfsdui-lie-di-gui-zhan-kvwhy/
	Queue<Integer> queue = new LinkedList<>();
	public NestedIterator(List<NestedInteger> nestedList) {
		dfs(nestedList);
	}

	@Override
	public Integer next() {
		return queue.isEmpty() ? -1 : queue.poll();
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	private void dfs(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return;
		}

		for (NestedInteger nested : nestedList) {
			if (nested.isInteger()) {
				queue.add(nested.getInteger());
			} else {
				dfs(nested.getList());
			}
		}
	}
}
