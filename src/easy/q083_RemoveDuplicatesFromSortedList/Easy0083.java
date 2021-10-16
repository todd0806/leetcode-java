package easy.q083_RemoveDuplicatesFromSortedList;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class Easy0083 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head;
		while (cur != null) {
			if (cur.next != null && cur.val == cur.next.val) {
				if (cur.next.next == null) {
					cur.next = null;
				} else {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}
