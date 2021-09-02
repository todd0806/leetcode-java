package hard.q239_SlidingWindowMaximum;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Todd
 *https://leetcode.com/problems/sliding-window-maximum/
 */
public class Solution {
	public static void main(String[] args) {
		int[] q = new int[] {1,3,-1,-3,5,3,6,7};
		new Solution().maxSlidingWindow(q, 3);
	}
	/**Dequee
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		int[] ans = new int[len - k + 1];
//		[index]
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 0; i < k; i++) {
			while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.addLast(i);
		}
		ans[0] = nums[deque.peekFirst()];
		
		for(int i = k; i < len; i++) {
			if(deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.addLast(i);
			ans[i - k + 1] = nums[deque.peekFirst()];
		}
		return ans;
	}
	
	/**PriorityQueue
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindowV1(int[] nums, int k) {
		int len = nums.length;
		int[] returnArray = new int[len - k + 1];
		
		// [val, index]
		PriorityQueue<int[]> priorityQ = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o2[1];
			}
		});
		
		for(int i = 0; i < k; i++) {
			priorityQ.offer(new int[] {nums[i], i});
		}
		returnArray[0] = priorityQ.peek()[0];
		for(int i = k; i < len; i++) {
			priorityQ.offer(new int[] {nums[i], i});
			while(priorityQ.peek()[1] <= i - k) {
				priorityQ.poll();
			}
			returnArray[i - k + 1] = priorityQ.peek()[0];
		}
		
		return returnArray;
	}
	
//	方法一：优先队列
//	思路与算法
//	https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/

//	复杂度分析
//	时间复杂度：O(nlogn)，其中 nn 是数组nums 的长度。在最坏情况下，数组 nums 中的元素单调递增，那么最终优先队列中包含了所有元素，
//	没有元素被移除。由于将一个元素放入优先队列的时间复杂度为 O(logn)，因此总时间复杂度为O(nlogn)。
//	空间复杂度：O(n)，即为优先队列需要使用的空间。这里所有的空间复杂度分析都不考虑返回的答案需要的 O(n) 空间，只计算额外的空间使用。

//	public int[] maxSlidingWindow(int[] nums, int k) {
//		int n = nums.length;
//		// [val, index]
//		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
//			public int compare(int[] pair1, int[] pair2) {
//				return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
//			}
//		});
//		for (int i = 0; i < k; ++i) {
//			pq.offer(new int[] { nums[i], i });
//		}
//		int[] ans = new int[n - k + 1];
//		ans[0] = pq.peek()[0];
//		for (int i = k; i < n; ++i) {
//			pq.offer(new int[] { nums[i], i });
//			while (pq.peek()[1] <= i - k) {
//				pq.poll();
//			}
//			ans[i - k + 1] = pq.peek()[0];
//		}
//		return ans;
//	}
	
//	方法二：单调队列
//	https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
//	复杂度分析
//
//	时间复杂度：O(n)，其中 nn 是数组 nums 的长度。每一个下标恰好被放入队列一次，并且最多被弹出队列一次，因此时间复杂度为 O(n)。
//	空间复杂度：O(k)。与方法一不同的是，在方法二中我们使用的数据结构是双向的，
//	因此「不断从队首弹出元素」保证了队列中最多不会有超过 k+1k+1 个元素，因此队列使用的空间为 O(k)。
//	public int[] maxSlidingWindow(int[] nums, int k) {
//		int n = nums.length;
//		Deque<Integer> deque = new LinkedList<Integer>();
//		for (int i = 0; i < k; ++i) {
//			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//				deque.pollLast();
//			}
//			deque.offerLast(i);
//		}
//	
//		int[] ans = new int[n - k + 1];
//		ans[0] = nums[deque.peekFirst()];
//		for (int i = k; i < n; ++i) {
//			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
//				deque.pollLast();
//			}
//			deque.offerLast(i);
//			while (deque.peekFirst() <= i - k) {
//				deque.pollFirst();
//			}
//			ans[i - k + 1] = nums[deque.peekFirst()];
//		}
//		return ans;
//	}


}
