package medium.q019_RemovNthNodeFromEndofList;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class Solution {
	// https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/589304/CLEAR-JAVA-SOLUTION-WITH-DETAILED-EXPLANATION!
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		ListNode slow = dummy, fast = dummy;
		dummy.next = head;
		for(int i = 1; i <= n + 1; i++){
			fast = fast.next;
		}
		while(fast != null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
