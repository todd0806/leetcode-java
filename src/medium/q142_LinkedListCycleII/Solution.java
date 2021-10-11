package medium.q142_LinkedListCycleII;

public class Solution {
	
	//https://labuladong.gitbook.io/algo/mu-lu-ye/lian-biao-ji-qiao#pan-duan-lian-biao-shi-fou-bao-han-huan
	public ListNode detectCycle(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				break;
			}
		}

		// not found
		if (fast == null || fast.next == null) {
			return dummy;
		}

		slow = head;
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
