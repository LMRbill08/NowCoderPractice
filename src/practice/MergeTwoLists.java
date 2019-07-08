package practice;
/*
 * give two ListNodes that are progressive increase 
 * merge them into one ListNode that is still progressive increase
 */
public class MergeTwoLists {
	public static void main(String[] args) {
		int[] list1 = { 1, 3, 3, 5, 7, 9 };
		int[] list2 = { 2, 4, 6, 8, 9, 10 };
		ListNode head1 = new ListNode(list1[0]);
		initListNode(list1, head1);
		ListNode head2 = new ListNode(list2[0]);
		initListNode(list2, head2);
		// ListNode result = mergeList(head1, head2);
		ListNode result = merge1(head1, head2);
		printListNode(result);
	}

	// use recursion 
	public static ListNode merge1(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val <= list2.val) {
			list1.next = merge1(list1.next, list2);
			return list1;
		} else {
			list2.next = merge1(list1, list2.next);
			return list2;
		}
	}
	
	// no recursion 
	public static ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		if (head1.next == null) {
			return head2;
		}
		if (head2.next == null) {
			return head1;
		}
		if (head1.val <= head2.val) {
			head1.next = merge(head1.next, head2);
			return head1;
		} else {
			head2.next = merge(head1, head2.next);
			return head2;
		}
	}

	public static void initListNode(int[] list, ListNode head) {
		ListNode temp = head;
		for (int i = 1; i < list.length; i++) {
			ListNode node = new ListNode(list[i]);
			temp.next = node;
			temp = temp.next;
		}
	}

	public static void printListNode(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println("\n");
	}
}
