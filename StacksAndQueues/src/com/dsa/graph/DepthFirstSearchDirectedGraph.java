package com.dsa.graph;


public class DepthFirstSearchDirectedGraph {
	
	Graph graph;
	MyStack<Vertex> stack = null;
	
	public DepthFirstSearchDirectedGraph() {
		graph = new Graph();
		graph.addVertex("A", 0);
		graph.addVertex("B", 1);
		graph.addVertex("C", 2);
		graph.addVertex("D", 3);
		graph.addVertex("E", 4);
		graph.addVertex("F", 5);
		graph.addVertex("G", 6);
		graph.addVertex("H", 7);
		graph.addVertex("I", 8);
		graph.addEdge(0, 1);
		graph.addEdge(1, 0);
		
		graph.addEdge(0, 2);
		graph.addEdge(2, 0);
		
		graph.addEdge(0, 3);
		graph.addEdge(3, 0);
		
		graph.addEdge(0, 4);
		graph.addEdge(4, 0);
		
		
		graph.addEdge(1, 5);
		graph.addEdge(5, 1);
		
		graph.addEdge(3, 6);
		graph.addEdge(6, 3);
		
		graph.addEdge(5, 7);
		graph.addEdge(7, 5);
		
		graph.addEdge(6, 8);
		graph.addEdge(8, 6);
		
		stack = new MyStack<Vertex>(Graph.MAX_VERTEX, Vertex[].class);
	}
	
	public static void main(String[] args) {
		DepthFirstSearchDirectedGraph dfs = new DepthFirstSearchDirectedGraph();
		dfs.execute();
	}

	private void execute() {
		Vertex[] vertices =	graph.getVertexList();
		for (int i = 0; i < graph.getnCurr(); i++) {
			vertices[i].display();
			vertices[i].setVisited(true);
			stack.push(vertices[i]);		
			
			while (!stack.isEmpty()) {
				Vertex vertex = getAdjascentVertex(stack.peek().getIndex());
				if (vertex != null) {
					vertex.display();
					vertex.setVisited(true);
					stack.push(vertex);				
				} else {
					stack.pop();
				}
			}
			// after visiting all vertices, set the visited flag to false again.
			for (Vertex vertex : vertices) {
				if (vertex != null)
					vertex.setVisited(false);
			}
			System.out.println();
		}		
	}
	
	private Vertex getAdjascentVertex(int index) {
		int[][] adj = graph.getAdj();
		Vertex[] vertices = graph.getVertexList();
		for (int j = 0; j < graph.getnCurr(); j++) {
			if (adj[index][j] == 1 && !vertices[j].isVisited()) {
				return vertices[j];
			}
		}
		return null;
	}
}
