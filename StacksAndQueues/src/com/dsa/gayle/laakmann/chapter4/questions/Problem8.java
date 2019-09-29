package com.dsa.gayle.laakmann.chapter4.questions;

/*
 * You have two very large binary trees: Tl, with millions of nodes, and T2, with
 * hundreds of nodes. Create an algorithm to decide if T2 is a subtree ofTl. 
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n
 * is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class Problem8 {
	
	/*
	 * An alternative approach is to search through the larger tree, Tl. Each time a node in Tl
	 * matches the root of T2, call treeMatch. The treeMatch method will compare the two
	 * subtrees to see if they are identical
	 */
	public boolean isSubtreeAlternate(MyNode tree, MyNode subTree) {
		if (subTree == null) {
			return true;
		}
		return isSubtreeFind(tree, subTree);
	}
	
	public boolean isSubtreeFind(MyNode tree, MyNode subTree) {
		if (tree == null) {
			return false;
		}
		if (tree.getValue() == subTree.getValue()) {
			return isMatch(tree, subTree);
		}
		return isSubtreeFind(tree.getLeftChild(), subTree) || isSubtreeFind(tree.getRightChild(), subTree);
	}
	
	public boolean isMatch(MyNode tree, MyNode subTree) {
		if (tree == null && subTree == null) {
			return true;
		}
		if (tree == null || subTree == null) {
			return false;
		}
		if (tree.getValue() != subTree.getValue()) {
			return false;
		}
		return isMatch(tree.getLeftChild(), subTree.getLeftChild()) && isMatch(tree.getRightChild(), subTree.getRightChild());
	}
	
	/*
	 * This method will check if the inorder of root2 is a subset of inorder of root1 and
	 * preorder of root2 is a subset of preorder of root1.
	 *
	 * Note that we'll need to insert a special character into our strings to indicate when a
	 * left or right node is NULL. Otherwise, we would be unable to distinguish between the
	 * following cases:
	 * 			5		5
	 * 		5				5
	 */
	public void isSubtree(MyNode root, MyNode subroot) {
		String treeInorderString = inorder(root, "");
		String subtreeInorderString = inorder(subroot, "");
		String treePreorderString = preorder(root, "");
		String subtreePreorderString = preorder(subroot, "");
		System.out.println("Main tree : " + treeInorderString);
		System.out.println("Sub tree : " + subtreeInorderString);
		
		System.out.println("Is subtree : " + (treeInorderString.contains(subtreeInorderString) && treePreorderString.contains(subtreePreorderString)));
	}
	
	public String inorder(MyNode root, String inorderStr) {
		if (root != null) {
			inorderStr = inorder(root.getLeftChild(), inorderStr);
			inorderStr = inorderStr + root.getValue();
			inorderStr = inorder(root.getRightChild(), inorderStr);
		} else {
			inorderStr = inorderStr + "0";
		}
		return inorderStr;
	}
	
	public String preorder(MyNode root, String inorderStr) {
		if (root != null) {
			inorderStr = inorderStr + root.getValue();
			inorderStr = preorder(root.getLeftChild(), inorderStr);			
			inorderStr = preorder(root.getRightChild(), inorderStr);
		} else {
			inorderStr = inorderStr + "0";
		}
		return inorderStr;
	}
	
	public static void main(String[] args) {
				/*
				5
			4		6
		2				9
					7		10
					*/
		MyBinaryTree tree = new MyBinaryTree();
		tree.insertWithParentRef(5);
		tree.insertWithParentRef(4);
		tree.insertWithParentRef(6);
		tree.insertWithParentRef(2);
		tree.insertWithParentRef(9);
		tree.insertWithParentRef(10);
		tree.insertWithParentRef(7);
		
		MyBinaryTree subtree = new MyBinaryTree();		
		subtree.insertWithParentRef(6);
		subtree.insertWithParentRef(9);
		subtree.insertWithParentRef(10);
		subtree.insertWithParentRef(7);
		
		Problem8 p = new Problem8();
		p.isSubtree(tree.getRoot(), subtree.getRoot());
		System.out.println("Alternate approach...");
		System.out.println("Is subtree : " + p.isSubtreeAlternate(tree.getRoot(), subtree.getRoot()));
	}

}
