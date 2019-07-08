package practice;
/*
 * 
 */

public class FindKFromTailOfLinkList {
	private static int K = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8 };
		ListNode head = new ListNode(list[0]);
		initListNode(list, head);
		printListNode(head);
		ListNode res2 = findKFromTail(K, head);
		System.out.println("\n\ntarget is: " + res2.val);
	}

	//
	public static ListNode findKFromTail(int k, ListNode head) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode a = head;
		ListNode b = head;
		for (int i = 1; i < k; i++) {
			if (b.next != null) {
				b = b.next;
			} else {
				return null;
			}
		}
		while (b.next != null) {
			a = a.next;
			b = b.next;
		}
		return a;
	}

	// initialize LinkList
	public static void initListNode(int[] list, ListNode head) {
		ListNode temp = head;
		for (int i = 1; i < list.length; i++) {
			ListNode node = new ListNode(list[i]);
			temp.next = node;
			temp = temp.next;
		}
	}

	// print LinkList
	public static void printListNode(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println("\n");
	}

}
