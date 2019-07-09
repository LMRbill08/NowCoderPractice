package practice;

/*
 * given a LinkedList, return the reversed LinkedList of it  
 */

public class ReverseListNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8 };
		ListNode head = new ListNode(list[0]);
		initListNode(list, head);
		printListNode(head);
		ListNode result = reverse(head);
		printListNode(result);
	}

	// reverse list node 
	public static ListNode reverse(ListNode head) {
		if (head == null) return null;
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

	/*
	 *  reverse list node every 3 nodes each time. 
	 *  for example: 1->2->3->4->5->6  => 3->2->1->6->5->4
	 */
	public static ListNode reverseEachThree(ListNode head) {
		if (head == null) return null;
		ListNode grpHead = head;
		ListNode grpEnd = null;
		
		ListNode pre = null;
		ListNode cur = head;
		ListNode temp = null;
		while(cur.val % 3 != 0) {
			temp = cur.next;
			
		}
		
		return null;
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
