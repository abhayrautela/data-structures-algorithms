package com.dsa.graph;

public class TopologicalSortingWithDirectedGraph {
	private GraphWithAdjListMatrix graph;

	public TopologicalSortingWithDirectedGraph() {
		graph = new GraphWithAdjListMatrix();
		graph.addVertex("A", 0);
		graph.addVertex("B", 1);
		graph.addVertex("C", 2);
		graph.addVertex("D", 3);
		graph.addVertex("E", 4);
		graph.addVertex("F", 5);
		graph.addVertex("G", 6);
		graph.addVertex("H", 7);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 6);
		graph.addEdge(4, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
	}

	public static void main(String[] args) {
		TopologicalSortingWithDirectedGraph sort = new TopologicalSortingWithDirectedGraph();
		sort.graph.display();
		sort.performTopologicalSort();
	}

	private Vertex noSuccessor() {
		for (Vertex v : graph.getVertexList()) {
			if (v.getAdj() == null || v.getAdj().size() == 0) {
				return v;
			}
		}
		return null;
	}

	public void performTopologicalSort() {
		int sortIndex = graph.getnCurr() - 1;
		String arr[] = new String[graph.getnCurr()];
		while (graph.getVertexList().size() > 0) {
			// find vertex with no successer
			Vertex v = noSuccessor();
			if (v == null) {
				System.out.println("Graph is cyclic");
				return;
			}
			arr[sortIndex--] = v.getLabel();
			graph.remove(v);
		}
		System.out.println("*************************");
		for (String x : arr) {
			System.out.println(x);
		}
	}
}
