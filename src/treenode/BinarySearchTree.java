package treenode;

import java.util.ArrayList;

public class BinarySearchTree {

	// check if a tree is a BST using normal method
	public static boolean isBST(TreeNode tree) {
		return false;
	}

	// check if a tree is a BST using in-order traversal
	public static boolean isBST2(TreeNode tree) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Traversal.inOrderTraversal(tree, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < list.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	// given an array, check if its the post-order traversal of a BST tree
	public static boolean isPostOfBST(int[] array) {
		int len = array.length;
		if (len == 0) {
			return false;
		}
		int root = len - 1;
		int rootVal = array[root];
		boolean result = isPost(array, 0, len - 2, rootVal);
		return result;
	}

	public static boolean isPost(int[] array, int start, int end, int val) {
		boolean cur = false;
		boolean left = false;
		boolean right = false;
		if (start == end) {
			cur = true;
			return cur;
		}
		int mid = start;
		while (mid <= end && array[mid] < val) {
			mid++;
		}
		int leftLen = mid - start;
		int rightLen = end - mid + 1;
		int index = mid;

		// check current tree
		while (index <= end && array[index] > val) {
			index++;
		}
		if (index == end + 1) {
			cur = true;
		} else {
			cur = false;
			return cur;
		}

		if (leftLen >= 0) {
			if (leftLen == 1 || leftLen == 0) {
				left = true;
			} else {
				left = isPost(array, start, mid - 2, array[mid - 1]);
			}
		}
		if (rightLen >= 0) {
			if (rightLen == 1 || rightLen == 0) {
				right = true;
			} else {
				right = isPost(array, mid, end - 1, array[end]);
			}
		}
		if (cur && left && right) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * given a BST, return a double linked list of the BST
	 */
	TreeNode temp = null;
	TreeNode result = null;

	public TreeNode convert(TreeNode root) {
		if (root == null)
			return null;
		convert(root.left);
		if (temp == null) {
			temp = root;
			result = root;
		} else {
			root.left = temp;
			temp.right = root;
			temp = root;
		}
		convert(root.right);
		return result;
	}

}
