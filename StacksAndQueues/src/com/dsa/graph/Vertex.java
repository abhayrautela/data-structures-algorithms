package com.dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	private String label;
	private int index;
	private List<Vertex> adj;
	private boolean isVisited;
	private int cumulativeShortestPath;

	public Vertex(String label, int index) {
		this.label = label;
		this.index = index;
		this.isVisited = false;
		this.adj = new ArrayList<Vertex>();
	}

	public int getCumulativeShortestPath() {
		return cumulativeShortestPath;
	}

	public void setCumulativeShortestPath(int cumulativeShortestPath) {
		this.cumulativeShortestPath = cumulativeShortestPath;
	}

	public List<Vertex> getAdj() {
		return adj;
	}

	public int getIndex() {
		return index;
	}

	public String getLabel() {
		return label;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	@Override
	public String toString() {
		return "Vertex [label=" + label + "]";
	}

	public void display() {
		System.out.print(label);
	}
}
