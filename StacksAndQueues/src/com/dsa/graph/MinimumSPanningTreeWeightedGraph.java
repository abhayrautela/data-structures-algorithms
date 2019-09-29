package com.dsa.graph;


public class MinimumSPanningTreeWeightedGraph {
	
	private WeightedGraph graph;
	
	private VertexPriorityQueue pQueue;
	
	public MinimumSPanningTreeWeightedGraph() {
		graph = new WeightedGraph();		
		graph.addVertex("A", 0);
		graph.addVertex("B", 1);
		graph.addVertex("C", 2);
		graph.addVertex("D", 3);
		graph.addVertex("E", 4);
		graph.addVertex("F", 5);
		
		graph.addEdge(0, 1, 6);
		graph.addEdge(0, 3, 4);
		
		graph.addEdge(1, 0, 6);
		graph.addEdge(1, 3, 7);
		graph.addEdge(1, 4, 7);
		graph.addEdge(1, 2, 10);
		
		graph.addEdge(2, 1, 10);
		graph.addEdge(2, 3, 8);
		graph.addEdge(2, 4, 5);
		graph.addEdge(2, 5, 6);
		
		graph.addEdge(3, 0, 4);
		graph.addEdge(3, 1, 7);
		graph.addEdge(3, 2, 8);
		graph.addEdge(3, 4, 12);
		
		graph.addEdge(4, 1, 7);
		graph.addEdge(4, 2, 5);
		graph.addEdge(4, 3, 12);
		graph.addEdge(4, 5, 7);
		
		graph.addEdge(5, 2, 6);
		graph.addEdge(5, 4, 7);
		pQueue = new VertexPriorityQueue(graph.getnCurr());
	}

	public static void main(String[] args) {
		MinimumSPanningTreeWeightedGraph mstw = new MinimumSPanningTreeWeightedGraph();
		mstw.execute();
	}

	private void execute() {
		Vertex[] vList = graph.getVertexList();
		int[][] adj = graph.getAdj();
		int nVertex = graph.getnCurr();
		int currVertex = 0;
		int index = 0;
				 
		// Algo will iterate nVertex times
		while (index < nVertex-1) {
			vList[currVertex].setVisited(true);
			index++;
			// insert adjacent edges to priority queue.
			for (int i=0; i<nVertex; i++) {
				/* 
				 * In adjacent matrix, x,y = 0 means there is no edge.
				 * Any value > 0 is the weight of the edge.
				 */
				if (adj[currVertex][i] > 0 && !vList[i].isVisited()) {
					// push to priority queue
					pQueue.insertWithSwap(adj[currVertex][i], vList[i].getLabel(), currVertex, i);
				}
			}
			Edge ed = pQueue.remove();			
			System.out.println(vList[ed.getSrcIndex()].getLabel() + ed.getDestVertexName());	
			currVertex = ed.getDestIndex();
		}
		
	}

}
