package com.dsa.trees.binary;


/**
 * This class will convert a postfix expression like ABC+* to a binary tree
 * @author rautelaa
 *
 */
public class PostFixToBT {
	
	enum TYPE {
		OPERATOR, OPERAND, OPEN_PARENTHESIS, CLOSE_PARENTHESIS
	}
	
	public static void main (String args[]) {
		String postFix = "256+*";
		int size = postFix.length();
		TreeStack stack = new TreeStack(size);
		String ch;
		for (int i = 0; i < size; i++) {
			ch = postFix.substring(i, i+1);
			TYPE type = getType(ch);
			switch (type) {
			case OPERAND:
				Node node = new Node(Integer.parseInt(ch));
				stack.push(node);
				break;
			case OPERATOR:
				Node rootNode = new Node(ch);
				rootNode.setRightChild(stack.pop());
				rootNode.setLeftChild(stack.pop());
				stack.push(rootNode);
				break;
			default:
				System.out.println("Improper input");
				break;
			}
		}
		/*
		 * After the loop is complete, the stack will have a single node which is the
		 * root node of the complete binary tree.
		 * 				*
		 * 			2			+
		 * 					5		6
		 */
		BinaryTree tree = new BinaryTree(stack.pop());
	}
	
	private static TYPE getType(String ch) {
		if (ch.equals("("))
			return TYPE.OPEN_PARENTHESIS;
		else if (ch.equals(")"))
			return TYPE.CLOSE_PARENTHESIS;
		else if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"))
			return TYPE.OPERATOR;
		else 
			return TYPE.OPERAND;
	}
}
