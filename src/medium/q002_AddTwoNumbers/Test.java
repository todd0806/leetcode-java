package medium.q002_AddTwoNumbers;

public class Test {
	public static void main(String[] args) {
		ListNode l1 = getListNode(new int[] { 1 });
//        ListNode l2 = getListNode(new int[]{1, 2, 3, 4, 5});
		ListNode l2 = getListNode(new int[] { 1, 5 });
		print(new Solution().addTwoNumbers(l1, l2));
		System.out.println();
	}

	private static ListNode getListNode(int[] arr) {
		ListNode headNode = null;
		for (int i = arr.length - 1; i >= 0; i--) {
			headNode = new ListNode(arr[i], headNode);
		}
		return headNode;
	}

	private static void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val);
			listNode = listNode.next;
		}
	}
}
