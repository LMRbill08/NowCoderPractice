package treenode;
/*
 * 1. give the in-order and pre-order traversal of a tree 
 * 2. reconstruct the tree and return the in-order and pre-order of the tree 
 * 3. check if a tree is the subtree (sub-structure) of another tree 
 */

public class ReConstructBinaryTree {

	/*
	 * Reconstruct Binary Tree according to the given pre-order and in-order
	 * traversal
	 */
	public static TreeNode reConstruct1(int[] pre, int[] in) {
		int preLen = pre.length;
		int inLen = in.length;
		if (preLen == 0 || preLen != inLen) {
			return null;
		}
		TreeNode tree = reConstructBinaryTree1(pre, in, 0, preLen - 1, 0, inLen - 1);
		return tree;
	}

	private static TreeNode reConstructBinaryTree1(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
		TreeNode tree = new TreeNode(pre[pStart]);
		tree.left = null;
		tree.right = null;
		int root = iStart;
		while (root <= iEnd && in[root] != pre[pStart]) {
			root++;
		}
		int leftLen = root - iStart;
		int rightLen = iEnd - root;
		if (leftLen > 0) {
			tree.left = reConstructBinaryTree1(pre, in, pStart + 1, pStart + leftLen, iStart, root - 1);
		}
		if (rightLen > 0) {
			tree.right = reConstructBinaryTree1(pre, in, pStart + leftLen + 1, pEnd, root + 1, iEnd);
		}
		return tree;
	}

	/*
	 * Reconstruct Binary Tree according to the given post-order and in-order
	 * traversal
	 */
	public static TreeNode reConstruct2(int[] post, int[] in) {
		int postLen = post.length;
		int inLen = in.length;
		if (postLen == 0 || postLen != inLen)
			return null;
		TreeNode tree = reConstructBinaryTree2(post, in, 0, postLen - 1, 0, inLen - 1);
		return tree;
	}

	private static TreeNode reConstructBinaryTree2(int[] post, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
		TreeNode tree = new TreeNode(post[pEnd]);
		tree.left = null;
		tree.right = null;
		int root = 0;
		while (root <= iEnd && in[root] != post[pEnd]) {
			root++;
		}
		int leftLen = root - iStart;
		int rightLen = iEnd - root;
		if (leftLen > 0) {
			tree.left = reConstructBinaryTree2(post, in, pStart, pStart + leftLen - 1, iStart, root - 1);
		}
		if (rightLen > 0) {
			tree.right = reConstructBinaryTree2(post, in, pStart + leftLen, pEnd - 1, root + 1, iEnd);
		}
		return tree;
	}

	/*
	 * given a Binary Tree, return its Mirror tree
	 */
	public static void Mirror(TreeNode tree) {
		if (tree == null)
			return;
		if (tree.left != null && tree.right != null) {
			TreeNode temp = tree.left;
			tree.left = tree.right;
			tree.right = temp;
			Mirror(tree.left);
			Mirror(tree.right);
		} else if (tree.left != null) {
			tree.right = tree.left;
			tree.left = null;
			Mirror(tree.right);
		} else if (tree.right != null) {
			tree.left = tree.right;
			tree.right = null;
			Mirror(tree.left);
		}
	}
}
