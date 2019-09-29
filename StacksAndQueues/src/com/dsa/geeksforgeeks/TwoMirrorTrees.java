package com.dsa.geeksforgeeks;

import com.dsa.gayle.laakmann.chapter4.questions.MyNode;

public class TwoMirrorTrees {
	
	boolean areMirror(MyNode a, MyNode b) 
    {
        // Your code here
        if (a==null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            return a.getValue() == b.getValue() && areMirror(a.getLeftChild(), b.getRightChild()) 
            && areMirror(a.getRightChild(), b.getLeftChild());
        }
        return false;
    }

}
