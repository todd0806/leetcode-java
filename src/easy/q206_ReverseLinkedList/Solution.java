package easy.q206_ReverseLinkedList;

/**
 * @author Todd https://leetcode.com/problems/reverse-linked-list/
 *
 *In-place iterative and recursive Java solution
 *https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
 *
 *animation
 *https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0206-Reverse-Linked-List/Animation/Animation.gif
 *
 *http://www.algorithmsandme.com/reverse-a-linked-list/
 */
public class Solution {
	
	/**iterative version
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode cur) {
		ListNode pre = null;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
