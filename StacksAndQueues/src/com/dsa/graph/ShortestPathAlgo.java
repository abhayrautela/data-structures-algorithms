package com.dsa.graph;

/*
 * This program will create a N by N matrix for shortest path from all x,y combination of vertices.
 */
public class ShortestPathAlgo {

	private Graph graph;

	public ShortestPathAlgo() {
		graph = new Graph(5);
		graph.addVertex("A", 0);
		graph.addVertex("B", 1);
		graph.addVertex("C", 2);
		graph.addVertex("D", 3);
		graph.addVertex("E", 4);
		
		graph.addDirectedEdge(0, 1, 50);
		graph.addDirectedEdge(0, 3, 80);
		graph.addDirectedEdge(1, 3, 90);
		graph.addDirectedEdge(1, 2, 60);
		graph.addDirectedEdge(2, 4, 40);
		graph.addDirectedEdge(3, 2, 20);
		graph.addDirectedEdge(3, 4, 70);
		graph.addDirectedEdge(4, 1, 50);
	}

	public static void main(String[] args) {
		ShortestPathAlgo s = new ShortestPathAlgo();
		s.execute();
	}

	private void execute() {
		int nVertex = graph.getnCurr();
		String[][] shortestPathMatrix = new String[nVertex][nVertex];
		/*
		 * Each cell (x,y) in shortest path matrix will contain shortest path from x to y via cell z 
		 * ie. '<shortest path from x to y>:<via z>'. Example cell (0,1) may contain string '50:3' which
		 * means the shortest path from 0 to 1 vertex is 50 and it goes through vertex 3.
		 */
		for (int x = 0; x < nVertex; x++) {
			// set all (x,x) cells to 0:null as it shortest path from one vertex to same vertex does
			// not make sense.
			shortestPathMatrix[x][x] = "0:null";
		}
		Vertex[] vList = graph.getVertexList();
		for (int i = 0; i < nVertex; i++) {
			Vertex currVertex = vList[i];			
			VertexPriorityQueue vpq = new VertexPriorityQueue(nVertex);
			for (int j = 0; j < nVertex - 1; j++) {
				currVertex.setVisited(true);
				int noUnvisitedAdjEdges = addToPQueue(vpq, currVertex.getIndex());
				if (noUnvisitedAdjEdges == 0)
					break;
				Edge e = null;
				while(true) {
					e = vpq.remove();
					if (!vList[e.getDestIndex()].isVisited())
						break;
				}				
				int weight = e.getWeight();
				vList[e.getDestIndex()].setCumulativeShortestPath(vList[e.getDestIndex()].getCumulativeShortestPath() + weight);
				int destIdx = e.getDestIndex();
				shortestPathMatrix[i][destIdx] = String.valueOf(weight) + ":" + "via " + String.valueOf(currVertex.getIndex());
				currVertex = vList[destIdx];				
			}
			reset();
		}
		displayShortestpathMatrix(shortestPathMatrix);
	}
	
	private void reset() {
		Vertex[] vList = graph.getVertexList();
		for (Vertex v : vList) {
			v.setVisited(false);
			v.setCumulativeShortestPath(0);
		}
	}

	private void displayShortestpathMatrix(String[][] shortestPathMatrix) {
		for (int i = 0; i < graph.getnCurr(); i++) {
			for (int j = 0; j < graph.getnCurr(); j++) {
				System.out.print(shortestPathMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private int addToPQueue(VertexPriorityQueue vpq, int index) {
		int noUnvisitedAdjEdges = 0;
		int[][] adj = graph.getAdj();
		Vertex[] vList = graph.getVertexList();
		for (int i = 0; i < graph.getnCurr(); i++) {
			if (adj[index][i] > 0 && !vList[i].isVisited()) {
				vpq.insert(adj[index][i] + vList[index].getCumulativeShortestPath(), vList[i].getLabel(), index, i);
				noUnvisitedAdjEdges++;
			}
		}
		return noUnvisitedAdjEdges;
	}

}
