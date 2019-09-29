package com.dsa.graph;

public class Edge {
	private int weight;
	private String destVertexName;
	private int srcIndex;
	private int destIndex;

	public Edge(int weight, String destVertexName, int srcIndex, int destIndex) {
		this.weight = weight;
		this.destVertexName = destVertexName;
		this.srcIndex = srcIndex;
		this.destIndex = destIndex;
	}

	public int getSrcIndex() {
		return srcIndex;
	}

	public void setSrcIndex(int srcIndex) {
		this.srcIndex = srcIndex;
	}

	public int getDestIndex() {
		return destIndex;
	}

	public void setDestIndex(int destIndex) {
		this.destIndex = destIndex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getDestVertexName() {
		return destVertexName;
	}

	public void setDestVertexName(String destVertexName) {
		this.destVertexName = destVertexName;
	}
}
