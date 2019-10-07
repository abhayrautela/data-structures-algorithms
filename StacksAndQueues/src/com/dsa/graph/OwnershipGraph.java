package com.dsa.graph;

import java.util.*;
import java.util.stream.IntStream;

public class OwnershipGraph {

    private List<Vertex> vertexList;
    private int nCurr;
    private boolean isDirected;

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public int getnCurr() {
        return nCurr;
    }

    public OwnershipGraph(boolean isDirected) {
        vertexList = new ArrayList<Vertex>();
        this.isDirected = isDirected;
    }

    public void addVertex(String label, int index) {
        Vertex vertex = new Vertex(label, index);
        vertexList.add(index, vertex);
        nCurr++;
    }

    public void addEdge(int start, int end, float directOwnership) throws Exception {
        if (start < 0 || end < 0 || start >= nCurr || end >= nCurr) {
            throw new Exception("Invalid start or end vertex id");
        }
        if (start == end) {
            throw new Exception("Edge start and end cannot be same vertex.");
        }
        vertexList.get(start).addEdge(vertexList.get(end), directOwnership);
    }

    public Set<Edge> getAdjascentVertices(int v) throws Exception {
        if (v < 0 || v >= nCurr) {
            throw new Exception("Invalid vertex id");
        }
        return vertexList.get(v).getAdj();
    }

    public long getIndegree(int v) throws Exception {
        if (v < 0 || v >= nCurr) {
            throw new Exception("Invalid vertex id");
        }
        return IntStream.range(0, nCurr - 1).filter(i -> vertexList.get(i).getAdj().contains(v)).count();
    }

    public void bfsTraversal(int start) throws Exception {
        if (start < 0 || start >= nCurr) {
            throw new Exception("Invalid vertex id");
        }
        vertexList.get(start).setCumulativeOwnership(100.00F);
        Queue<Edge> q = new LinkedList<>();
        q.addAll(vertexList.get(start).getAdj());
        while (!q.isEmpty()) {
            Edge e = q.poll();
            float cumulativeOwnership = calculateCumulativeOwnerhip(e.getSource().getCumulativeOwnership(), e.getDirectOwnership());
            e.getDestination().setCumulativeOwnership(cumulativeOwnership + e.getDestination().getCumulativeOwnership());
            for (Edge edge : e.getDestination().getAdj()) {
                q.add(edge);
            }
        }
    }

    private float calculateCumulativeOwnerhip(float cumulativeOwnership, float directOwnership) {
        return (directOwnership / 100) * cumulativeOwnership;
    }

//    public void dfsTraversal(int current, int[] visited) throws Exception {
//        if (current < 0 || current >= nCurr) {
//            throw new Exception("Invalid vertex id");
//        }
//        if (visited[current] == 1) {
//            return;
//        }
//        visited[current] = 1;
//        System.out.println(vertexList.get(current).getIndex() + ":" + vertexList.get(current).getLabel());
//        for (Vertex v : vertexList.get(current).getAdj()) {
//            dfsTraversal(v.getIndex(), visited);
//        }
//    }

    public static void main(String[] args) throws Exception {
        OwnershipGraph g = new OwnershipGraph(true);
        g.addVertex("A", 0);
        g.addVertex("B", 1);
        g.addVertex("C", 2);
        g.addVertex("D", 3);
        try {
            g.addEdge(3, 2, 30.0F);
            g.addEdge(3, 0, 65.0F);
            g.addEdge(3, 1, 5.0F);
            g.addEdge(2, 0, 100.0F);
            g.addEdge(1, 0, 50.0F);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        g.bfsTraversal(3);
        System.out.println();
    }

}
