package practice;

import java.util.ArrayList;

/*
 * 1. give the in-order and pre-order traversal of a tree 
 * 2. reconstruct the tree and return the in-order and pre-order of the tree 
 * 3. check if a tree is the subtree (sub-structure) of another tree 
 */

public class ReConstructBinaryTree {

	static ArrayList<Integer> preList = new ArrayList<Integer>();
	static ArrayList<Integer> inList = new ArrayList<Integer>();
	static ArrayList<Integer> postList = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode tree = reConstruct(pre, in);

		int[] subPre = { 3, 5, 6 };
		int[] subIn = { 5, 3, 6 };
		TreeNode subTree = reConstruct(subPre, subIn);

		boolean isSubTree = isSubTree(tree, subTree);
		boolean isSubStructure = isSubStructure(tree, subTree);
		System.out.println("if Tree B is the subtree of Tree A: " + isSubTree);
		System.out.println("if Tree B is the substructure of Tree A: " + isSubStructure);

//		preOrderTraversal(tree);
//		System.out.println(preList.toString());
//		inOrderTraversal(tree);
//		System.out.println(inList.toString());
//		postOrderTraversal(tree);
//		System.out.println(postList.toString());
	}

	/*
	 * Reconstruct Binary Tree according to the given pre-order and in-order
	 * traversal
	 */
	public static TreeNode reConstruct(int[] pre, int[] in) {
		int preLen = pre.length;
		int inLen = in.length;
		if (preLen == 0 || inLen == 0) {
			return null;
		}
		TreeNode tree = reConstructBinaryTree(pre, in, 0, preLen - 1, 0, inLen - 1);
		return tree;
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd) {
		TreeNode tree = new TreeNode(pre[pStart]);
		tree.left = null;
		tree.right = null;
		int root = 0;
		while (root <= iEnd && in[root] != pre[pStart]) {
			root++;
		}
		int leftLen = root - iStart;
		int rightLen = iEnd - root;
		if (leftLen > 0) {
			tree.left = reConstructBinaryTree(pre, in, pStart + 1, pStart + leftLen, iStart, root - 1);
		}
		if (rightLen > 0) {
			tree.right = reConstructBinaryTree(pre, in, pStart + leftLen + 1, pEnd, root + 1, iEnd);
		}
		return tree;
	}

	/*
	 * check if tree2 is the subtree of tree1
	 */
	public static boolean isSubTree(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null || tree2 == null) // empty tree can't be the subtree of any other trees
			return false;
		boolean result = false;
		if (tree1.val == tree2.val) { // if the two values are identical, then call checkSubTree to check their
										// subtrees
			result = checkSubTree(tree1, tree2);
		}
		if (!result) {
			result = isSubTree(tree1.left, tree2);
		}
		if (!result) {
			result = isSubTree(tree1.right, tree2);
		}
		return result;
	}

	public static boolean checkSubTree(TreeNode t1, TreeNode t2) {
		// both tree1 and tree2 has finished checking at the last node
		if (t1 == null && t2 == null) {
			return true;
		} else if (t1 != null && t2 != null) { // if both tree1 and tree2 is not empty, then ...
			if (t1.val != t2.val) { // if two values of tree1 and tree2 are different, then return false
				return false;
			} else { // if two values are identical, then check their left and right trees using
						// recursion
				return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
			}
		} else {
			return false;
		}
	}

	/*
	 * check if tree2 is the sub-structure of tree1
	 */
	public static boolean isSubStructure(TreeNode t1, TreeNode t2) {
		boolean result = false;
		if (t1 == null || t2 == null)
			return false;
		if (t1.val == t2.val) {
			result = checkSubStructure(t1, t2);
		}
		if (!result) {
			result = isSubStructure(t1.left, t2);
		}
		if (!result) {
			result = isSubStructure(t1.right, t2);
		}
		return result;
	}

	public static boolean checkSubStructure(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;
		else if (t1 == null)
			return false;
		else if (t1 != null && t2 != null) {
			if (t1.val != t2.val) {
				return false;
			} else {
				return checkSubStructure(t1.left, t2.left) && checkSubStructure(t1.right, t2.right);
			}
		}
		return false;
	}

	/*
	 * Three different types of Traversal based on depth-first-search: Pre Order, In
	 * Order, Post Order
	 */

	// pre-order traversal the Binary Tree (using recursion)
	public static ArrayList<Integer> preOrderTraversal(TreeNode tree) {
		if (tree == null) {
			return preList;
		}
		preList.add(tree.val);
		preOrderTraversal(tree.left);
		preOrderTraversal(tree.right);
		return preList;
	}

	// in-order traversal the Binary Tree (using recursion)
	public static ArrayList<Integer> inOrderTraversal(TreeNode tree) {
		if (tree == null) {
			return inList;
		}
		inOrderTraversal(tree.left);
		inList.add(tree.val);
		inOrderTraversal(tree.right);
		return inList;
	}

	// post-order traversal the Binary Tree (using recursion)
	public static ArrayList<Integer> postOrderTraversal(TreeNode tree) {
		if (tree == null) {
			return postList;
		}
		postOrderTraversal(tree.right);
		postList.add(tree.val);
		postOrderTraversal(tree.left);
		return postList;
	}

}
