package practice;

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
