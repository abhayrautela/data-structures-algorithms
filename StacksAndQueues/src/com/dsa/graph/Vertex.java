package com.dsa.graph;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Vertex {

    private String label;
    private int index;
    private Set<Edge> adj;
    private float cumulativeOwnership;

    public Vertex(String label, int index) {
        this.label = label;
        this.index = index;
        this.adj = new TreeSet<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge v1, Edge v2) {
                if (v1.getDestination().getIndex() < v2.getDestination().getIndex()) {
                    return -1;
                } else if (v1.getDestination().getIndex() > v2.getDestination().getIndex()) {
                    return 1;
                }
                return 0;
            }
        });
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                ", index=" + index +
                ", adj=" + adj +
                ", cumulativeOwnership=" + cumulativeOwnership +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public String getLabel() {
        return label;
    }

    public void addEdge(Vertex destination, float directOwnership) {
        if (this.index != destination.getIndex()) {
            Edge e = new Edge(directOwnership, this, destination);
            this.adj.add(e);
        }
    }

    public float getCumulativeOwnership() {
        return cumulativeOwnership;
    }

    public void setCumulativeOwnership(float cumulativeOwnership) {
        this.cumulativeOwnership = cumulativeOwnership;
    }

    public Set<Edge> getAdj() {
        return adj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return index == vertex.index &&
                Float.compare(vertex.cumulativeOwnership, cumulativeOwnership) == 0 &&
                Objects.equals(label, vertex.label) &&
                Objects.equals(adj, vertex.adj);
    }

    @Override
    public int hashCode() {

        return Objects.hash(label, index, adj, cumulativeOwnership);
    }
}
