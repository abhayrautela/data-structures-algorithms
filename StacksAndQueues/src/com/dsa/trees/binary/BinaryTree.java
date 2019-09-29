package com.dsa.trees.binary;

public class BinaryTree {
	
	private Node root;
	
	public BinaryTree(Node root) {
		this.root = root;
	}
	
	public Node find (int x) {
		Node current = root;
		if (current == null)
			return null;
		while (current != null && current.getData() != x) {
			if (x < current.getData()) 
				current = current.getLeftChild();
			else
				current = current.getRightChild();
		}
		return current;
	}
	
	public Node getRoot() {
		return root;
	}

	public void insert(int x) {
		Node newNode = new Node(x);
		Node current = root;
		Node parent = null;
		if (current == null) {
			current = newNode;
			return;
		}
		while (true) {
			parent = current;
			if (current.getData() == x) {
				System.out.println("Node already exists.");
				return;
			}
			if (x < current.getData()) {
				current = current.getLeftChild();
				if (current == null) {
					parent.setLeftChild(newNode);
					return;
				}
			} else {
				current = current.getRightChild();
				if (current == null) {
					parent.setRightChild(newNode);
					return;
				}
			}
		}
	}
	
	public Node minimum(Node current) {
		Node parent = null;
		while (current != null) {
			parent = current;
			current = current.getLeftChild();
		}
		return parent;
	}
	
	public Node maximum(Node current) {
		Node parent = null;
		while (current != null) {
			parent = current;
			current = current.getRightChild();
		}
		return parent;
	}
	
	public void inorder(Node localNode) {
		if (localNode != null) {
			inorder(localNode.getLeftChild());
			System.out.println(localNode.getData());
			inorder(localNode.getRightChild());
		}
	}
	
	public void preorder(Node localNode) {
		if (localNode != null) {
			System.out.println(localNode.getData());
			preorder(localNode.getLeftChild());
			preorder(localNode.getRightChild());
		}
	}
	
	public void postorder(Node localNode) {
		if (localNode != null) {			
			postorder(localNode.getLeftChild());
			postorder(localNode.getRightChild());
			System.out.println(localNode.getData());
		}
	}
	
	public void delete (Node node) {
		Node current = root;
		Node parent = null;
		boolean isLeftNode = false;
		if (root == null) {
			System.out.println("Tree is empty.");
		}
		while (current != null) {
			if (current.getData() == node.getData()) {
				if (current.getLeftChild() == null && current.getRightChild() == null) {
					deleteLeafNode(parent, isLeftNode);
				} else if ((current.getLeftChild() == null && current.getRightChild() != null)
						||(current.getLeftChild() != null && current.getRightChild() == null)) {
					deleteNodeWithOneChild(parent, current, isLeftNode);
				} else {
					deleteNodeWithTwoChild(parent, current, isLeftNode);
				}
				break;
			} else if (current.getData() > node.getData()) {
				parent = current;
				current = current.getLeftChild();
				isLeftNode = true;
			} else {
				parent = current;
				current = current.getRightChild();
				isLeftNode = false;
			}
		}
	}

	private void deleteNodeWithTwoChild(Node parent, Node current, boolean isLeftNode) {		
		Node successorNode = current.getRightChild();
		Node successorParent = current;
		while (successorNode.getLeftChild() != null) {
			successorParent = successorNode;
			successorNode = successorNode.getLeftChild();
		}
		if (successorParent != current) {
			if (successorNode.getRightChild() == null) {			
				successorParent.setLeftChild(null);			
			} else {
				successorParent.setLeftChild(successorNode.getRightChild());
			}
			successorNode.setLeftChild(current.getLeftChild());
			successorNode.setRightChild(current.getRightChild());
			if (isLeftNode) {			
				parent.setLeftChild(successorNode);
			}			
			else {
				parent.setRightChild(successorNode);
			}
		} else {
			if (parent == null) {
				current.getLeftChild().setRightChild(successorNode);
				root = current.getLeftChild();
			} else {
				if (isLeftNode)
					parent.setLeftChild(successorNode);
				else
					parent.setRightChild(successorNode);
			}			
		}
	}

	private void deleteNodeWithOneChild(Node parent, Node current,
			boolean isLeftNode) {
		Node node = current.getLeftChild() != null ? current.getLeftChild() : current.getRightChild();
		if (isLeftNode) {
			parent.setLeftChild(node);
		} else {
			parent.setRightChild(node);
		}
	}

	private void deleteLeafNode(Node parent, boolean isleftNode) {
		if (isleftNode)
			parent.setLeftChild(null);
		else
			parent.setRightChild(null);		
	}
	
	public static void main(String[] args) {
		Node root = new Node(50); 
		BinaryTree bt = new BinaryTree(root);
		bt.insert(75);
		bt.insert(62);
		bt.insert(87);
		bt.insert(77);
		bt.insert(93);
		bt.insert(79);
		bt.find(100);
		bt.inorder(bt.getRoot());
		bt.delete(new Node(75));
		bt.inorder(bt.getRoot());
	}

}
