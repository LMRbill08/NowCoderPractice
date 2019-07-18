package treenode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

	/*
	 * Three different types of Traversal based on depth-first-search: Pre Order, In
	 * Order, Post Order. Idea of it is DFS，depth-first-search
	 */

	// pre-order traversal the Binary Tree (using recursion)
	public static void preOrderTraversal(TreeNode tree, ArrayList<Integer> list) {
		if (tree == null) {
			return;
		}
		list.add(tree.val);
		preOrderTraversal(tree.left, list);
		preOrderTraversal(tree.right, list);
	}

	// in-order traversal the Binary Tree (using recursion)
	public static void inOrderTraversal(TreeNode tree, ArrayList<Integer> list) {
		if (tree == null) {
			return;
		}
		inOrderTraversal(tree.left, list);
		list.add(tree.val);
		inOrderTraversal(tree.right, list);
	}

	// post-order traversal the Binary Tree (using recursion)
	public static void postOrderTraversal(TreeNode tree, ArrayList<Integer> list) {
		if (tree == null) {
			return;
		}
		postOrderTraversal(tree.right, list);
		list.add(tree.val);
		postOrderTraversal(tree.left, list);
	}

	/*
	 * tree traversal according to the level of node. Idea of it is
	 * BFS，breadth-first-search
	 */
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			list.add(node.val);
		}
		return list;
	}

	// return the depth of a tree
	public static int TreeDepth(TreeNode tree) {
		if (tree == null) {
			return 0;
		}
		int leftDepth = TreeDepth(tree.left);
		int rightDepth = TreeDepth(tree.right);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	/*
	 * given a binary tree and an integer, return a list contains all the paths of
	 * nodes whose sum is that integer.
	 */
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return paths;
		}
		find(paths, new ArrayList<Integer>(), root, target);
		return paths;
	}

	public static void find(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode tree, int target) {
		path.add(tree.val);
		if (tree.left == null && tree.right == null) {
			if (tree.val == target) {
				paths.add(path);
			}
			return;
		}
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		path2.addAll(path);
		if (tree.left != null) {
			find(paths, path, tree.left, target - tree.val);
		}
		if (tree.right != null) {
			find(paths, path2, tree.right, target - tree.val);
		}
	}
}
