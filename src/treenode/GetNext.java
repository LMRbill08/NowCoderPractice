package treenode;

/*
 * given a binary tree and one of its node, return its next node according to the in-order traversal 
 */

public class GetNext {
	public static TreeLinkNode function(TreeLinkNode node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
		while (node.next != null) {
			if (node.next.left == node) {
				return node.next;
			}
			node = node.next;
		}
		return null;
	}
}
