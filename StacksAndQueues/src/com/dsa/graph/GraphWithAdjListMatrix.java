package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphWithAdjListMatrix {

	private List<Vertex> vertexList;
	// public static final int MAX_VERTEX = 20;
	private int nCurr;

	public List<Vertex> getVertexList() {
		return vertexList;
	}

	public int getnCurr() {
		return nCurr;
	}

	public GraphWithAdjListMatrix() {
		vertexList = new ArrayList<Vertex>();
	}

	public void addVertex(String label, int index) {
		Vertex vertex = new Vertex(label, index);
		vertexList.add(vertex);
		nCurr++;
	}

	public void addEdge(int start, int end) {
		// directed graph
		vertexList.get(start).getAdj().add(vertexList.get(end));
	}

	public void displayVertex(int i) {
		System.out.println(vertexList.get(i).getLabel());
	}
	
	public void remove (Vertex ver) {
		vertexList.remove(ver);
		nCurr--;
		for (Vertex v : vertexList) {
			for (Vertex adj : v.getAdj()) {
				if (adj.equals(ver)) {
					v.getAdj().remove(adj);
					break;
				}
			}
		}
	}

	public void display() {
		for (Vertex v : vertexList) {
			System.out.println(v.getLabel() + " Adjacent to ");
			for (Vertex v1 : v.getAdj()) {
				System.out.println(v1.getLabel() + "	");
			}
		}
	}

}
