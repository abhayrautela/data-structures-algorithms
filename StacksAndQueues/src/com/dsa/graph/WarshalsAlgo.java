package com.dsa.graph;

public class WarshalsAlgo {
	
	private Graph graph;
	
	public WarshalsAlgo() {
		graph = new Graph(5);
		graph.addVertex("A", 0);
		graph.addVertex("B", 1);
		graph.addVertex("C", 2);
		graph.addVertex("D", 3);
		graph.addVertex("E", 4);
		
		graph.addDirectedEdge(0, 2);
		
		graph.addDirectedEdge(1, 0);
		graph.addDirectedEdge(1, 4);
		
		graph.addDirectedEdge(3, 4);
		
		graph.addDirectedEdge(4, 2);		
	}
	
	public static void main(String[] args) {
		WarshalsAlgo wa = new WarshalsAlgo();
		wa.display();
		wa.execute();
		System.out.println("after applying warshal's algo");
		wa.display();
	}

	private void display() {
		graph.displayAdj();
		
	}

	private void execute() {
		for (int row = 0; row < graph.getnCurr(); row++) {
			for (int col = 0; col < graph.getnCurr(); col++) {
				if (graph.getAdj()[row][col] == 1) {
					for (int x = 0; x < graph.getnCurr(); x++) {
						if (graph.getAdj()[x][row] == 1) {
							graph.getAdj()[x][col] = 1;
						}
					}
				}
			}
		}
	}

}
