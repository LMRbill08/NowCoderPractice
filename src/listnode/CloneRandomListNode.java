package listnode;

public class CloneRandomListNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * given the head of a RandomListNode, return the head of the copy list of this
	 * RandomListNode.
	 */
	public static RandomListNode clone(RandomListNode pHead) {
		if (pHead == null)
			return null;

		// 1. 遍历链表，复制每个节点并link到当前节点的下一个节点
		RandomListNode cur = pHead;
		while (cur != null) {
			RandomListNode copiedCurNode = new RandomListNode(cur.label);
			RandomListNode nextNode = cur.next;
			copiedCurNode.next = nextNode;
			cur.next = copiedCurNode;
			cur = nextNode;
		}
		// 2. 给复制的节点添加Random节点
		cur = pHead;
		while (cur != null) {
			cur.next.random = cur.random == null ? null : cur.random.next; // if it's cur.random, then the two nodes are
																			// identical
			cur = cur.next.next;
		}
		// 3. 将链表分开
		cur = pHead;
		RandomListNode result = cur.next;
		RandomListNode temp = result;
		while (cur != null) {
			cur.next = temp.next;
			cur = cur.next;
			temp.next = cur == null ? null : cur.next;
			temp = temp.next;
		}
		return result;
	}

}
