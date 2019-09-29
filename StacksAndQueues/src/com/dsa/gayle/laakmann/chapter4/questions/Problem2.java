package com.dsa.gayle.laakmann.chapter4.questions;

import com.dsa.graph.MyGenericQueue;


/*
 * Given a directed graph, design an algorithm to find out whether there is a route
 * between two nodes.
 */
public class Problem2 {
	
	private MyGraph graph = null;
	
	public Problem2() {
		graph = new MyGraph(9);
		graph.addNode("A", 0);
		graph.addNode("B", 1);
		graph.addNode("C", 2);
		graph.addNode("D", 3);
		graph.addNode("E", 4);
		graph.addNode("F", 5);
		graph.addNode("G", 6);
		graph.addNode("H", 7);
		graph.addNode("I", 8);
		
		graph.addDirectedEdge(0, 1);
		graph.addDirectedEdge(0, 2);
		graph.addDirectedEdge(0, 3);
		graph.addDirectedEdge(0, 4);
		graph.addDirectedEdge(1, 5);
		graph.addDirectedEdge(5, 7);
		graph.addDirectedEdge(3, 6);
		graph.addDirectedEdge(6, 8);
		
	}
	
	public static void main(String[] args) {
		Problem2 p = new Problem2();
		boolean doesRouteExist = p.searchRouteUsingDFS(1, 4);
		System.out.println(doesRouteExist);
		doesRouteExist = p.searchRouteUsingDFS(0, 4);
		System.out.println(doesRouteExist);
		
		doesRouteExist = p.searchRouteUsingBFS(1, 4);
		System.out.println(doesRouteExist);
		doesRouteExist = p.searchRouteUsingBFS(0, 4);
		System.out.println(doesRouteExist);
	}

	private boolean searchRouteUsingDFS(int src, int dest) {		
		com.dsa.graph.MyStack<MyVertex> vStack = new com.dsa.graph.MyStack<MyVertex>(9, MyVertex[].class);
		vStack.push(graph.getVertex(src));
		while (!vStack.isEmpty()) {
			MyVertex v = graph.getUnvisitedAdjVertex(vStack.peek().getIndex());			
			if (v != null) {
				if (v.getIndex() == dest) {
					return true;
				} else {
					vStack.push(v);
				}
			} else {
				vStack.pop();
			}
		}
		
		// reset visited flag
		graph.resetVisitedFlag();
		return false;
	}
	
	private boolean searchRouteUsingBFS(int src, int dest) {		
		MyGenericQueue<MyVertex> vQueue = new MyGenericQueue<MyVertex>(9, MyVertex[].class);
		vQueue.insert(graph.getVertex(src));
		graph.getVertex(src).setVisited(true);
		while (!vQueue.isEmpty()) {
			MyVertex v = graph.getUnvisitedAdjVertex(vQueue.peek().getIndex());			
			if (v != null) {
				if (v.getIndex() == dest) {
					return true;
				} else {
					vQueue.insert(v);
				}
			} else {
				vQueue.remove();
			}
		}
		// reset visited flag
		graph.resetVisitedFlag();
		return false;
	}
	
}
