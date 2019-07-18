package listnode;

import java.util.*;

public class PrintListNodeFromTailToHead {
	public static ArrayList<Integer> list1 = new ArrayList<Integer>();

	// use recursion to add them into ArrayList
	public static ArrayList<Integer> function1(ListNode node) {
		if (node != null) {
			function1(node.next);
			list1.add(node.val);
		}
		return list1;
	}

	// use stack to push ListNode and then pop them out into ArrayList
	public static void function2(ListNode node) {
		Stack<Integer> stack = new Stack<Integer>();
		ListNode temp = node;
		while (temp != null) {
			stack.push(temp.val);
			temp = temp.next;
		}
		while (!stack.empty()) {
			list1.add(stack.pop());
		}
	}

	// reverse ListNode and print
	public static void function3(ListNode node) {
		if (node == null) {
			System.out.println("the ListNode is Null!");
		}
		ListNode pre = null;
		ListNode cur = node;
		ListNode temp = cur.next;
		while (temp != null) {
			cur.next = pre;
			pre = cur;
			cur = temp;
			temp = temp.next;
		}
		cur.next = pre;

		while (cur != null) {
			list1.add(cur.val);
			cur = cur.next;
		}
	}
}
