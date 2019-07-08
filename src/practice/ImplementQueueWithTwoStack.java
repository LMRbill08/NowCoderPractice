package practice;
import java.util.Stack;

public class ImplementQueueWithTwoStack {

	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack1.empty() && stack2.empty()) {
			throw new RuntimeException("queue is empty!");
		}

		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
