package listnode;

/*
 * the ListNode is sorted 
 * given the head of a list node, delete all the duplicated nodes and return the result 
 */
public class DeleteDuplication {
	public static ListNode function(ListNode pHead) {
		ListNode result = new ListNode(0); // head node
		result.next = pHead;
		ListNode newNode = result;
		ListNode cur = pHead;
		while (cur != null) {
			if (cur.next != null && cur.val == cur.next.val) {
				while (cur.next != null && cur.val == cur.next.val) {
					cur = cur.next;
				}
				newNode.next = cur.next;
				cur = cur.next;
			} else {
				newNode = newNode.next;
				cur = cur.next;
			}
		}
		
		return result.next;
	}
}
