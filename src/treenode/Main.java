package treenode;

import java.util.ArrayList;

public class Main {
	static ArrayList<Integer> preList = new ArrayList<Integer>();
	static ArrayList<Integer> inList = new ArrayList<Integer>();
	static ArrayList<Integer> postList = new ArrayList<Integer>();
	static ArrayList<Integer> levelList = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("================Construct trees================");
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		int[] post = { 7, 4, 2, 5, 8, 6, 3, 1 };
		TreeNode tree1 = ReConstructBinaryTree.reConstruct1(pre, in);
		System.out.println("The level-order Traversal of tree1: " + Traversal.PrintFromTopToBottom(tree1).toString());
		TreeNode tree2 = ReConstructBinaryTree.reConstruct2(post, in);
		System.out.println("The depth of tree is: " + Traversal.TreeDepth(tree1));
		System.out.println("If the tree is a balanced tree: " + SubChecking.isBalanced(tree1));
		System.out.println(
				"If the two trees are equal with structure and values: " + SubChecking.isSubTree(tree1, tree2));
		System.out.println("===============================================");
		System.out.println();
		System.out.println("===========creating and checking a BST=========");
		int[] bstPre = { 5, 3, 2, 1, 4, 8, 6, 7, 10, 9 };
		int[] bstIn = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] bstPost = { 1, 2, 4, 3, 7, 6, 9, 10, 8, 5 };
		TreeNode bstTree = ReConstructBinaryTree.reConstruct2(bstPost, bstIn);
		boolean isBST = BinarySearchTree.isBST2(bstTree);
		System.out.println("If the tree is a BST: " + isBST);
		levelList = Traversal.PrintFromTopToBottom(bstTree);
		System.out.println("Level-order Traversal: " + levelList.toString());
		System.out.println("===============================================");
		System.out.println();
		System.out.println("check if the array is post-order traversal of a BST");
		System.out.println(BinarySearchTree.isPostOfBST(bstPost));
		System.out.println(BinarySearchTree.isPostOfBST(post));
		System.out.println("===============================================");
		System.out.println();
		System.out.println("=====check if it's subtree or substructure=====");
		int[] subPre = { 3, 5, 6 };
		int[] subIn = { 5, 3, 6 };
		TreeNode subTree = ReConstructBinaryTree.reConstruct1(subPre, subIn);
		boolean isSubTree = SubChecking.isSubTree(tree1, subTree);
		boolean isSubStructure = SubChecking.isSubStructure(tree1, subTree);
		System.out.println("if Tree B is the subtree of Tree A: " + isSubTree);
		System.out.println("if Tree B is the substructure of Tree A: " + isSubStructure);
		System.out.println("===============================================");
		System.out.println();
		System.out.println("===gives all paths that equals to the number===");
		int[] pathPre = { 1, 2, 7, 3, 6 };
		int[] pathIn = { 2, 7, 1, 3, 6 };
		TreeNode pathTree = ReConstructBinaryTree.reConstruct1(pathPre, pathIn);
		ArrayList<Integer> pathTreeLevelList = Traversal.PrintFromTopToBottom(pathTree);
		System.out.println("Level-order Traversal: " + pathTreeLevelList.toString());
		ArrayList<ArrayList<Integer>> paths = Traversal.FindPath(pathTree, 10);
		System.out.println(paths.toString());
		System.out.println("===============================================");
	}
}
