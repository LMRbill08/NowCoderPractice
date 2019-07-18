package listnode;

/*
 * give two ListNodes that are progressive increase 
 * merge them into one ListNode that is still progressive increase
 */
public class MergeTwoLists {

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

}
