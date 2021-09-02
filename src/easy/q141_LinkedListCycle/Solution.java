package easy.q141_LinkedListCycle;

/**
 * @author Todd 
 * 
 * https://leetcode.com/problems/linked-list-cycle/ 
 * 快慢指針
 * 
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		if(head == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
}
