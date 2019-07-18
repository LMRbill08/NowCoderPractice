package treenode;

public class SubChecking {
	/*
	 * check if tree2 is the subtree of tree1
	 */
	public static boolean isSubTree(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null || tree2 == null) // empty tree can't be the subtree of any other trees
		{
			return false;
		}
		boolean result = false;
		if (tree1.val == tree2.val) // if the two values are identical, then call checkSubTree to check their
									// subtrees
		{
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

	private static boolean checkSubTree(TreeNode t1, TreeNode t2) {
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
		if (t1 == null || t2 == null) {
			return false;
		}
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

	private static boolean checkSubStructure(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		} else if (t1 == null)
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

	// check if a tree is a balanced-tree
	public static boolean isBalanced(TreeNode tree) {
		if (tree == null) {
			return true;
		}
		int leftLen = Traversal.TreeDepth(tree.left);
		int rightLen = Traversal.TreeDepth(tree.right);
		int diff = Math.abs(leftLen - rightLen);
		if (diff <= 1)
			return true;
		else
			return false;
	}
}
