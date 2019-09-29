package com.dsa.graph;


public class BreadthFirstSearch {
	
	Graph graph;
	MyGenericQueue<Vertex> queue = null;
	
	public BreadthFirstSearch() {
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
		
		queue = new MyGenericQueue<Vertex>(Graph.MAX_VERTEX, Vertex[].class);
	}
	
	public static void main(String[] args) {
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.execute();
	}

	private void execute() {
		Vertex[] vertices =	graph.getVertexList();
		vertices[0].display();
		vertices[0].setVisited(true);
		queue.insert(vertices[0]);		
		
		while (!queue.isEmpty()) {
			Vertex vertex = getAdjascentVertex(queue.peek().getIndex());
			if (vertex != null) {
				vertex.display();
				vertex.setVisited(true);
				queue.insert(vertex);				
			} else {
				queue.remove();
			}		
		}
		// after visiting all vertices, set the visited flag to false again.
		for (Vertex ver : vertices) {
			if (ver != null)
				ver.setVisited(false);
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
