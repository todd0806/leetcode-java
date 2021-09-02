package easy.q206_ReverseLinkedList;

public class Test {
	public static void main(String[] args) {
		ListNode l1 = genListNode(new int[] { 1 });
//        Solution.ListNode l2 = getListNode(new int[]{1, 2, 3, 4, 5});
		ListNode l2 = genListNode(new int[] { 1, 5 });
//		print(new Solution().addTwoNumbers(l1, l2));
		print(l2);
	}

	private static ListNode genListNode(int[] arr) {
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
			if (listNode != null) {
				System.out.print(", ");
			}
		}
	}
}
