package com.dsa.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixToPostFix {
	
	enum TYPE {
		OPERATOR, OPERAND, OPEN_PARENTHESIS, CLOSE_PARENTHESIS
	}

	private StringBuffer postFix = new StringBuffer();
	private MyStringStack operatorStack = null;
	private MyStringStack operandStack = null;
	
	public static void main (String args[]) {
		InfixToPostFix inToPost = new InfixToPostFix();	
		System.out.print("Enter infix string :");
		System.out.flush();
		String input = "2+3*(9-3)";// getString();
		inToPost.postFIX(input);
		System.out.println("Postfix evaluation : " + inToPost.evaluatePostFix(inToPost.postFix.toString()));
	}
	
	private int evaluatePostFix(String input) {
		int size = input.length();
		int result = 0;
		operandStack = new MyStringStack(size);
		for (int i = 0; i < size; i++) {
			String ch = input.substring(i, i+1);
			TYPE type = getType(ch);
			switch (type) {
			case OPERATOR:
				result = applyOperator(operandStack.pop(), ch, operandStack.pop());
				operandStack.push(String.valueOf(result));
				break;
			case OPERAND:
				operandStack.push(ch);
				break;
			default:
				System.out.println("Improper postfix expression");
				break;
			}
		}
		return result;
	}

	private int applyOperator(String opnd1, String opr, String opnd2) {
		if (opr.equals("+"))
			return Integer.parseInt(opnd2) + Integer.parseInt(opnd1); 
		else if (opr.equals("-"))
			return Integer.parseInt(opnd2) - Integer.parseInt(opnd1);
		else if (opr.equals("*"))
			return Integer.parseInt(opnd2) * Integer.parseInt(opnd1);
		else
			return Integer.parseInt(opnd2) / Integer.parseInt(opnd1);
	}

	private void postFIX(String input) {
		int size = input.length();
		operatorStack = new MyStringStack(size);
		for (int i = 0; i < size; i++) {
			String ch = input.substring(i, i+1);
			TYPE type = getType(ch);
			switch (type) {
			case OPERAND:
				postFix.append(ch);
				break;
			case OPEN_PARENTHESIS:
				operatorStack.push(ch);
				break;
			case CLOSE_PARENTHESIS:
				performCloseParenthesis();
				break;
			case OPERATOR:
				performOperator(ch);
				break;
			default:
				System.out.println("Improper input");
				break;
			}
		}
		while (!operatorStack.isEmpty()) {
			postFix.append(operatorStack.pop());
		}
		System.out.println("Infix expression : " + input);
		System.out.println("Postfix expression : " + postFix.toString());
	}

	private void performOperator(String chThis) {
		if (operatorStack.isEmpty()) {
			operatorStack.push(chThis);
			return;
		}
		String chTop;
		if (!operatorStack.isEmpty()) {
			chTop = operatorStack.pop();
			if (getType(chTop) == TYPE.OPEN_PARENTHESIS)
				operatorStack.push(chTop);
			else 
				if (compare(chTop, chThis) < 1)
					operatorStack.push(chTop);
			else
				postFix.append(chTop);
		}
		operatorStack.push(chThis);
	}

	private void performCloseParenthesis() {
		String ch;
		while (!operatorStack.isEmpty()) {
			ch = operatorStack.pop();
			if (!(getType(ch) == TYPE.OPEN_PARENTHESIS)) {
				postFix.append(ch);
			} else
				break;
		}
		
	}
	
	private int compare(String ch1, String ch2) {
		if (((ch1.equals("+") || ch1.equals("-")) && (ch2.equals("+") || ch2.equals("-"))) ||
				((ch1.equals("*") || ch1.equals("/")) && (ch2.equals("*") || ch2.equals("/"))))
			return 0;
		else if ((ch1.equals("+") || ch1.equals("-")) && (ch2.equals("*") || ch2.equals("/")))
			return -1;
		else 
			return 1;
	}

	private TYPE getType(String ch) {
		if (ch.equals("("))
			return TYPE.OPEN_PARENTHESIS;
		else if (ch.equals(")"))
			return TYPE.CLOSE_PARENTHESIS;
		else if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/"))
			return TYPE.OPERATOR;
		else 
			return TYPE.OPERAND;
	}

	private static String getString() {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(is);
		String s = null;
		try {
			s = rd.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
}
