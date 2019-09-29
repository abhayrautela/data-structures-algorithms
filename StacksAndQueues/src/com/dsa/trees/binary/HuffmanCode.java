package com.dsa.trees.binary;

import com.dsa.queue.NodePriorityQueue;

public class HuffmanCode {
	
	public static void main(String[] args) {
		String s = "Eerie eyes seen near lake.";
		NodePriorityQueue pq = new NodePriorityQueue(s.length());
		for (int i = 0; i < s.length(); i++) {
			String c = s.substring(i, i + 1);
			int count = 1;
			for (int j = i + 1; j < s.length(); j++) {
				if (c.equals(s.substring(j, j + 1))) {
					count++;
				}
			}
			if (!pq.contains(c))
				pq.insert(count, c);
		}
		pq.display();
		
		while (pq.size() > 1) {
			Node node1 = pq.remove();
			Node node2 = pq.remove();
			Node huffNode = new Node(node1.getData() + node2.getData());
			huffNode.setLeftChild(node1);
			huffNode.setRightChild(node2);
			pq.insert(huffNode);
		}
		Node finalNode = pq.peekMin();
		System.out.println(finalNode);
	}

}
