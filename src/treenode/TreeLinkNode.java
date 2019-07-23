package treenode;

/*
 * the class of a Binary tree node, including the pointer to the parent node 
 */
public class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null; // pointing to the parent node

	TreeLinkNode(int val) {
		this.val = val;
	}
}
