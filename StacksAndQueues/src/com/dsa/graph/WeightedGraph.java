package com.dsa.graph;

public class WeightedGraph {
	
	private Vertex[] vertexList;
	public static final int MAX_VERTEX = 20;
	private int nCurr;
	private int[][] adj;
	
	public Vertex[] getVertexList() {
		return vertexList;
	}

	public void setVertexList(Vertex[] vertexList) {
		this.vertexList = vertexList;
	}

	public int getnCurr() {
		return nCurr;
	}

	public void setnCurr(int nCurr) {
		this.nCurr = nCurr;
	}

	public int[][] getAdj() {
		return adj;
	}

	public void setAdj(int[][] adj) {
		this.adj = adj;
	}

	public WeightedGraph() {
		vertexList = new Vertex[MAX_VERTEX];
		adj = new int[MAX_VERTEX][MAX_VERTEX];
		for (int i = 0; i < MAX_VERTEX; i++)
			for (int j = 0; j < MAX_VERTEX; j++) {
				adj[i][j] = 0;
			}
	}
	
	public WeightedGraph(int n) {
		vertexList = new Vertex[n];
		adj = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				adj[i][j] = 0;
			}
	}
	
	public void addVertex(String label, int index) {
		Vertex vertex = new Vertex(label, index);
		vertexList[nCurr++] = vertex;
	}
	
	public void addEdge(int start, int end, int weight) {
		adj[start][end] = weight;
		adj[end][start] = weight;
	}
	
	public void addDirectedEdge(int start, int end, int weight) {
		adj[start][end] = weight;
	}
	
	public void displayVertex(int i) {
		System.out.println(vertexList[i].getLabel());
	}
	
	public void displayAdj() {
		for (int x = 0; x<nCurr; x++) {
			for (int y = 0; y<nCurr; y++) {
				System.out.println("["+x+"]["+y+"] = " + adj[x][y]);
			}			
		}
	}

}
