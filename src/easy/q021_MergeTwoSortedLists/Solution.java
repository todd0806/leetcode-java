package easy.q021_MergeTwoSortedLists;

//https://leetcode.com/problems/merge-two-sorted-lists/solution/

public class Solution {

	public static void main(String[] args) {
//		System.out.print(isValid("){"));
	}
	// https://labuladong.gitbook.io/algo/mu-lu-ye/lian-biao-ji-qiao
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		
		if(l2 == null) {
			return l1;
		}
		ListNode dummy = new ListNode(-1), p = dummy;
		ListNode p1 = l1, p2 = l2;
		while(p1 != null && p2 != null ) {
			if(p1.val > p2.val) {
				p.next = p2;
				p2 = p2.next;
			}else {
				p.next = p1;
				p1 = p1.next;
			}
			p = p.next;
		}
		
		if(p1 != null) {
			p.next = p1;
		}
		if(p2 != null) {
			p.next = p2;
		}
		
		return dummy.next;
		
	}
	
//	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		if (l1 == null) {
//			return l2;
//		}
//		if (l2 == null) {
//			return l1;
//		}
//		if (l1.val < l2.val) {
//			l1.next = mergeTwoLists(l1.next, l2);
//			return l1;
//		} else {
//			l2.next = mergeTwoLists(l1, l2.next);
//			return l2;
//		}
//	}
}
