package medium.q002_AddTwoNumbers;

public class Test {
	public static void main(String[] args) {
		Solution.ListNode l1 = getListNode(new int[] { 1 });
//        Solution.ListNode l2 = getListNode(new int[]{1, 2, 3, 4, 5});
		Solution.ListNode l2 = getListNode(new int[] { 1, 5 });
		print(new Solution().addTwoNumbers(l1, l2));
		System.out.println();
	}

	private static Solution.ListNode getListNode(int[] arr) {
		Solution.ListNode headNode = null;
		for (int i = arr.length - 1; i >= 0; i--) {
			headNode = new Solution.ListNode(arr[i], headNode);
		}
		return headNode;
	}

	private static void print(Solution.ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val);
			listNode = listNode.next;
		}
	}
}
