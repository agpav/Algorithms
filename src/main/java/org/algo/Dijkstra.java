package org.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Dijkstra {

	public static final String DIR = "./src/main/resources/";
	public static final String FILE = DIR + "dijkstraData.txt";

	static final int SIZE = 201;

	public static void main(String[] args) throws Exception {
		Dijkstra d = new Dijkstra();
		d.execute();
	}

	public void execute() throws Exception {
		Graph graph = loadFile();
		graph.printWithLength();
		int[] distance = dijkstra(graph.nodes[1]);
		printSolution(distance);
		print(distance);
	}

	public void print(int[] distance) {
		int[] indices = { 7, 37, 59, 82, 99, 115, 133, 165, 188, 197 };
		IntStream.range(0, indices.length).forEach(i -> System.out.print(distance[indices[i]] + ","));
		Arrays.stream(indices).forEach(i -> System.out.print(distance[i] + ","));
	}

	void printSolution(int[] distance) {
		System.out.println("Vertex\t\tDistance from Source");
		IntStream.range(0, SIZE).filter(i -> i != 0).forEach(i -> System.out.println(i + "\t\t" + distance[i]));
	}

	public int[] dijkstra(Node source) {
		int[] distance = new int[SIZE];
		IntStream.range(0, SIZE).forEach(i -> distance[i] = 1000000);
		Set<Node> unSettledNodes = new HashSet<>();
		distance[source.value] = 0;
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Node node = getMinimum(unSettledNodes, distance);
			unSettledNodes.remove(node);
			for (Edge edge : node.edges) {
				int len = distance[node.value] + edge.weight;
				if (distance[edge.node.value] > len) {
					distance[edge.node.value] = len;
					unSettledNodes.add(edge.node);
				}
			}
		}
		return distance;
	}

	private Node getMinimum(Set<Node> nodes, int[] distance) {
		Node minimum = null;
		for (Node node : nodes) {
			if (minimum == null) {
				minimum = node;
			} else {
				if (distance[node.value] < distance[minimum.value]) {
					minimum = node;
				}
			}
		}
		return minimum;
	}

	private Graph loadFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(FILE));
		Graph graph = new Graph(SIZE);
		while (sc.hasNextLine()) {
			String[] arr = sc.nextLine().split("	");
			int source = Integer.parseInt(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				String[] edge = arr[i].split(",");
				graph.addEdge(source, Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
			}
		}
		sc.close();
		return graph;
	}
}
