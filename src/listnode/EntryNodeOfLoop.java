package listnode;

public class EntryNodeOfLoop {
	public static ListNode findEntryNode(ListNode head) {
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			if (fastNode == slowNode) {
				break;
			}
		}
		if (fastNode == null || fastNode.next == null) {
			System.out.println("链表中无环！");
			return null;
		}
		slowNode = head;
		while (slowNode != fastNode) {
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}
		return slowNode;
	}
}
