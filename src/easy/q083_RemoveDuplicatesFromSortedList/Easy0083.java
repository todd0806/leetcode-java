package easy.q083_RemoveDuplicatesFromSortedList;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class Easy0083 {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
		return head;
	}
}
