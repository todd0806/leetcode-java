package medium.q002_AddTwoNumbers;

//https://leetcode.com/problems/add-two-numbers/
public class Solution {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode curr = dummyHead;
		int carry = 0;

		while (p != null || q != null) {
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			p = p != null ? p.next : null;
			q = q != null ? q.next : null;
			curr = curr.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;

	}
}
