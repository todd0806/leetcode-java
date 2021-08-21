package easy.q083_RemoveDuplicatesFromSortedList;

import java.util.HashMap;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class Easy0083 {

	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(1);
		a.next.next = new ListNode(2);
		a.next.next.next = new ListNode(3);
		a.next.next.next.next = new ListNode(3);
		deleteDuplicates(a);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head != null && head.next == null) {
			return head;
		}
		ListNode now = head;
		ListNode next = head.next;
		while (next != null) {
			if (now.val == next.val) {
				if (next.next == null) {
					next = null;
					now.next = null;
				} else {
					next = next.next;
					now.next = next;
				}
			} else {
				now = next;
				next = next.next;
			}
		}
		return head;
	}

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
}
