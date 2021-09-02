package easy.q155_MinStack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
	/** initialize your data structure here. */
	Deque<Integer> stack;
	Deque<Integer> minStack;
			
	public MinStack() {
		stack = new LinkedList<>();
		minStack = new LinkedList<>();
	}

	public void push(int val) {
		stack.push(val);
		// maintain minStack
		if(minStack.isEmpty()) {
			minStack.push(val);
		}else {
			minStack.push(Math.min(val, minStack.peek()));
		}
	}

	public void pop() {
		stack.remove();
		minStack.remove();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
