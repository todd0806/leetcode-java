package easy.q160_IntersectionofTwoLinkedLists;

public class Solution {

	// https://labuladong.gitbook.io/algo/mu-lu-ye/lian-biao-ji-qiao#liang-ge-lian-biao-shi-fou-xiang-jiao
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode curA = headA, curB = headB;
		while (curA != curB) {
			if (curA == null) {
				curA = headB;
			} else {
				curA = curA.next;
			}

			if (curB == null) {
				curB = headA;
			} else {
				curB = curB.next;
			}
		}
		return curA;
	}
}
