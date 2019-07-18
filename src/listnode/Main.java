package listnode;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("=============List Reversion=============");
		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		ListNode head = new ListNode(list[0]);
		initListNode(list, head);
		System.out.println("original linked list: ");
		printListNode(head);
		head = ReverseListNode.reverse(head);
		System.out.println("reversed list using normal method: ");
		printListNode(head);
		head = ReverseListNode.reverseUsingStack(head);
		System.out.println("reversed list using stack method: ");
		printListNode(head);
		head = ReverseListNode.reverseEachK(head, 3);
		System.out.println("reversed list every k nodes: ");
		printListNode(head);
		head = ReverseListNode.reverse3(head);
		System.out.println("reversed list every k nodes: ");
		printListNode(head);

		System.out.println("=============Merge Two Linked Lists=============");
		int[] list1 = { 1, 3, 3, 5, 7, 9 };
		int[] list2 = { 2, 4, 6, 8, 9, 10 };
		ListNode head1 = new ListNode(list1[0]);
		initListNode(list1, head1);
		System.out.println("Linked List 1: ");
		printListNode(head1);
		ListNode head2 = new ListNode(list2[0]);
		initListNode(list2, head2);
		System.out.println("Linked List 2: ");
		printListNode(head2);
		// ListNode result = mergeList(head1, head2);
		ListNode result = MergeTwoLists.merge1(head1, head2);
		System.out.println("Result List: ");
		printListNode(result);

		System.out.println("==========Print From Tail To Head==========");
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ListNode head3 = new ListNode(arr[0]);
		initListNode(arr, head3);
		printListNode(head3);
		PrintListNodeFromTailToHead.function3(head3);
		System.out.println(PrintListNodeFromTailToHead.list1.toString() + "\n");

		System.out.println("==========Find Kth Node From Tail==========");
		int[] listFindK = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int K = FindKFromTailOfLinkList.K;
		ListNode headK = new ListNode(listFindK[0]);
		initListNode(listFindK, headK);
		printListNode(headK);
		ListNode res2 = FindKFromTailOfLinkList.findKFromTail(K, headK);
		System.out.println("\n\ntarget is: " + res2.val);
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
