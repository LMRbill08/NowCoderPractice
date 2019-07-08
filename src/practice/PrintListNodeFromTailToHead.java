package practice;
import java.util.*;

public class PrintListNodeFromTailToHead {
	static ArrayList<Integer> list1 = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode head = new ListNode(arr[0]);
		initListNode(arr, head);
		printListNode(head);
		function3(head);
		System.out.println(list1.toString());
	}

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

	// initialize ListNode 
	public static void initListNode(int[] list, ListNode head) {
		ListNode temp = head;
		for (int i = 1; i < list.length; i++) {
			ListNode node = new ListNode(list[i]);
			temp.next = node;
			temp = temp.next;
		}
	}

	// print ListNode 
	public static void printListNode(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println("\n");
	}
}
