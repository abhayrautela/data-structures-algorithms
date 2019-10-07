package com.dsa.graph;

import java.util.Objects;

public class Edge {
    private float directOwnership;

    @Override
    public String toString() {
        return "Edge{" +
                "directOwnership=" + directOwnership +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }

    private Vertex source;
    private Vertex destination;

    public Edge(float directOwnership, Vertex source, Vertex destination) {
        this.directOwnership = directOwnership;
        this.source = source;
        this.destination = destination;
    }

    public float getDirectOwnership() {
        return directOwnership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Float.compare(edge.directOwnership, directOwnership) == 0 &&
                Objects.equals(destination, edge.destination);
    }

    @Override
    public int hashCode() {

        return Objects.hash(directOwnership, destination);
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

}
