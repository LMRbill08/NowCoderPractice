package listnode;

import java.util.Stack;

/*
 * given a LinkedList, return the reversed LinkedList of it  
 */

public class ReverseListNode {
	static Stack<ListNode> stackRevN = new Stack<ListNode>();

	// reverse list node (normal method)
	public static ListNode reverse(ListNode head) {
		if (head == null)
			return null;
		ListNode pre = null;
		ListNode cur = head;
		ListNode temp = null;
		while (cur.next != null) {
			temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		cur.next = pre;
		return cur;
	}

	// reverse list node (using stack)
	public static ListNode reverseUsingStack(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		if (head == null)
			return null;
		ListNode temp = head;
		while (temp.next != null) {
			stack.push(temp);
			temp = temp.next;
		}
		stack.push(temp);

//		while (!stack.empty()) {
//			System.out.println(stack.pop().val);
//		}

		ListNode newHead = stack.pop();
		temp = newHead;
		while (!stack.empty()) {
			temp.next = stack.pop();
			temp = temp.next;
		}
		temp.next = null;
		return newHead;
	}

	/*
	 * reverse list node every k nodes each time. For example, when k = 3:
	 * 1->2->3->4->5->6 => 3->2->1->6->5->4
	 */
	public static ListNode reverseEachK(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode nextGrpHead = pushEveryN(head, k);
		ListNode newHead = stackRevN.pop();
		ListNode temp = newHead;
		while (!stackRevN.empty()) {
			temp.next = stackRevN.pop();
			temp = temp.next;
		}
		if (nextGrpHead.val % 3 == 0 || nextGrpHead.val / 3 == head.val / 3) {
			temp.next = null;
			return newHead;
		} else {
			temp.next = nextGrpHead;
		}
		ListNode newNextHead;

		while (nextGrpHead.next != null) {
			newNextHead = pushEveryN(nextGrpHead, k);
			while (!stackRevN.empty()) {
				temp.next = stackRevN.pop();
				temp = temp.next;
			}
			if (newNextHead.val % 3 == 0 || newNextHead.val / 3 == nextGrpHead.val / 3) {
				while (!stackRevN.empty()) {
					temp.next = stackRevN.pop();
					temp = temp.next;
				}
				temp.next = null;
			} else {
				temp.next = newNextHead;
				nextGrpHead = newNextHead;
			}
		}
		return newHead;
	}

	/*
	 * push every k nodes into stack, return the head of next iteration group, or
	 * the last node of current iteration group if it is the last node of the
	 * LinkedList. For example, 1->2->3->4, k = 3, the function returns 4; 1->2->3,
	 * the function returns 3
	 */
	private static ListNode pushEveryN(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode temp = head;
		while (temp.val % k != 0 && temp.next != null) {
			stackRevN.push(temp);
			temp = temp.next;
		}
		stackRevN.push(temp);
		if (temp.next != null) {
			ListNode nextGrpHead = temp.next;
			return nextGrpHead;
		} else {
			return temp;
		}
	}

	// normal method
	public static ListNode reverse3(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode cur = head, pre = null, nextNode = null, temp = null;
		int i = 1;
		while (cur != null) {
			// 一组循环有三个Node，分别为（pre, cur, nextNode）
			nextNode = cur.next;
			if (i % 3 == 2) {
				if (nextNode != null) {
					// 若nextNode为空，此时最后一循环中只有两个数，
					// 例如 ： 1，2，3，4，5，6，7，8
					pre.next = nextNode.next;
					cur.next = pre;
					nextNode.next = cur;
				} else {
					// 若nextNode不为空，此时最后一循环有三个数
					// 例如 ： 1，2，3，4，5，6，7，8，9
					cur.next = pre;
					pre.next = null;
				}
				if (i != 2) {
					if (nextNode != null) {
						// 若nextNode不为空，此时最后一循环有三个数
						// 例如 ： 1，2，3，4，5，6，7，8，9
						// temp的下一个节点为nextNode
						temp.next = nextNode;
					} else {
						// 若nextNode为空，此时最后一循环中只有两个数，
						// 例如 ： 1，2，3，4，5，6，7，8
						// 此时最终temp的下一个节点即为第二个节点cur
						temp.next = cur;
					}

				}
			}
			if (i % 3 == 1) {
				// 余1时，设置pre节点
				pre = cur;
			}
			if (i % 3 == 0) {
				// 若余0，则记录当前Node为temp，temp的next要变为下一组循环中的nextNode（第三个）
				temp = cur;
			}

			if (i == 2) {
				// 第一个循环，设置链表头，链表头为第三个Node
				head = nextNode;
			}
			i++;
			cur = cur.next;
			// System.out.println(i);
		}
		return head;
	}
}
