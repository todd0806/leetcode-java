package hard.q023_MergekSortedLists;

import java.util.PriorityQueue;

public class Solution {
//	https://leetcode.com/problems/merge-k-sorted-lists/discuss/10528/a-java-solution-based-on-priority-queue/11330
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode node : lists) {
			if (node != null) {
				queue.offer(node);
			}
		}

		while (!queue.isEmpty()) {
			ListNode item = queue.poll();
			cur.next = item;
			cur = cur.next;
			if (item.next != null) {
				queue.offer(item.next);
			}
		}
		return dummy.next;
	}
}
