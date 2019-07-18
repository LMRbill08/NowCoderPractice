package listnode;
/*
 * 
 */

public class FindKFromTailOfLinkList {
	public static int K = 5;

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
}
