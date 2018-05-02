package org.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SCC {

	public static final String DIR = "./src/main/resources/";
	public static final String FILE = DIR + "SCC.txt";

	int size = 875715;
	int t = 0;
	Graph graph = new Graph(size);
	Graph revGraph = new Graph(size);

	public static void main(String[] args) throws Exception {
		SCC scc = new SCC();
		scc.execute();
	}

	public void execute() throws Exception {
		loadFile();
		List<Node> list = revGraph.reverseArrangeByVal();
		dfs_loop(list);
		graph.copyFinishingTime(revGraph);
		list = graph.reverseArrangeByFinishingTime();
		dfs_loop(list);
		printScc(graph.nodes);
	}

	private void printScc(Node[] arr) {
		Map<Node, Long> scc = Arrays.stream(arr).filter(n -> n != null)
				.collect(Collectors.groupingBy(Node::getLeader, Collectors.counting()));
		scc.values().stream().sorted(Collections.reverseOrder()).forEach(n -> System.out.print(n + ","));
	}

	private void dfs_loop(List<Node> list) {
		list.stream().filter(n -> !n.isVisited).forEach(n -> dfs(list, n, n));
	}

	private void dfs(List<Node> list, Node node, Node leader) {
		node.isVisited = true;
		node.leader = leader;
		node.edges.stream().filter(e -> !e.node.isVisited).forEach(e -> dfs(list, e.node, leader));
		t++;
		node.finishingTime = t;
	}

	private void loadFile() throws FileNotFoundException {
		Scanner sc = new Scanner(new File(FILE));
		while (sc.hasNextLine()) {
			String[] arr = sc.nextLine().split(" ");
			graph.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			revGraph.addEdge(Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
		}
		sc.close();
	}
}