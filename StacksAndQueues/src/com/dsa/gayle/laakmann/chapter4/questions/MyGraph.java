package com.dsa.gayle.laakmann.chapter4.questions;

import java.util.ArrayList;
import java.util.List;

public class MyGraph {
	private List<MyVertex> vList;
	private int adj[][];
	private int nCurr;
	private int nMaxVertex; 
	private static final int MAX_VERTEX = 20;
	
	public MyGraph() {
		this.nMaxVertex = MAX_VERTEX;
		this.vList = new ArrayList<MyVertex>();
		this.adj = new int[MAX_VERTEX][MAX_VERTEX];		
	}
	
	public MyVertex getVertex(int idx) {
		return vList.get(idx);
	}
	
	public MyGraph(int nMaxVertex) {
		this.nMaxVertex = nMaxVertex;
		vList = new ArrayList<MyVertex>();
		adj = new int[nMaxVertex][nMaxVertex];
	}
	
	public boolean addNode(String label, int index) {
		if (nCurr == nMaxVertex) {
			return false;
		} else {
			MyVertex v = new MyVertex(label, index);
			vList.add(v);
			return true;
		}
	}
	
	public void addDirectedEdge(int srcIdx, int destIdx) {
		adj[srcIdx][destIdx] = 1;
	}
	
	public MyVertex getUnvisitedAdjVertex(int idx) {
		MyVertex v = null;
		for (int i=0; i<nMaxVertex; i++) {
			if (adj[idx][i] == 1 && vList != null && !vList.get(i).isVisited()) {
				v =  vList.get(i);
				v.setVisited(true);
			}
		}		
		return v;
	}
	
	public void resetVisitedFlag() {
		for (MyVertex v : vList) {
			v.setVisited(false);
		}
	}
}
