package org.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Graph {

	Node[] nodes;

	public Graph(int length) {
		nodes = new Node[length];
	}

	public void addEdge(int source, int destination) {
		addEdge(source, destination, 0);
	}

	public void addEdge(int source, int destination, int weight) {
		Node srcNode = getNode(source);
		Node destNode = getNode(destination);
		Edge edge = new Edge(destNode, weight);
		srcNode.addEdge(edge);
	}

	public Node getNode(int i) {
		Node node = nodes[i];
		if (node == null) {
			node = new Node(i);
			nodes[i] = node;
		}
		return node;
	}

	public void print() {
		Arrays.stream(nodes).filter(n -> n != null).forEach(n -> {
			System.out.print("\nNodes connected to Vertex " + n.value + " are : ");
			n.edges.stream().forEach(e -> System.out.print(" " + e.node.value));
		});
		System.out.println();
	}

	public void printWithLength() {
		Arrays.stream(nodes).filter(n -> n != null).forEach(n -> {
			System.out.print("\nNodes connected to Vertex " + n.value + " are : ");
			n.edges.stream().forEach(e -> System.out.print(" " + e.node.value + "," + e.weight));
		});
		System.out.println();
	}

	public void printFinishingTime() {
		Arrays.stream(nodes).filter(n -> n != null).forEach(n -> System.out.print(" " + n.finishingTime));
		System.out.println();
	}

	public void copyFinishingTime(Graph source) {
		IntStream.range(0, source.nodes.length).filter(i -> source.nodes[i] != null)
				.forEach(i -> nodes[i].finishingTime = source.nodes[i].finishingTime);
	}

	public List<Node> reverseArrangeByVal() {
		return Arrays.stream(nodes).filter(n -> n != null).sorted((n1, n2) -> Integer.compare(n1.value, n2.value) * -1)
				.collect(Collectors.toList());
	}

	public List<Node> reverseArrangeByFinishingTime() {
		return Arrays.stream(nodes).filter(n -> n != null)
				.sorted((n1, n2) -> Integer.compare(n1.finishingTime, n2.finishingTime) * -1)
				.collect(Collectors.toList());
	}
}

class Node {
	int value;
	boolean isVisited;
	int finishingTime;
	Node leader;
	List<Edge> edges = new ArrayList<>();

	public Node(int value) {
		this.value = value;
	}

	public Node getLeader() {
		return this.leader;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

}

class Edge {
	Node node;
	int weight;

	public Edge(Node node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}