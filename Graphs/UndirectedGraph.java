import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph {

	ArrayList<ArrayList<Integer>> adjacencyList;

	public UndirectedGraph(int vertices) {
		this.adjacencyList = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			this.adjacencyList.add(new ArrayList<Integer>());
		}
	}

	public void addEdge(int src, int dest) {
		adjacencyList.get(src).add(dest);
		adjacencyList.get(dest).add(src);
	}

	public int countVertices() {
		return this.adjacencyList.size();
	}

	public void printRecursiveDFS() {
		System.out.println("Graph DFS: ");
		int n = countVertices();
		int[] color = new int[n];

		// you can use this assuming that the graph is a connected graph.
		printRecursiveDFS(0, color);

		// if the graph is not a connected graph you can run the below code.
		// just remove the //s

//		int count = 0;
//		for (int i = 0; i < n; i++) {
//			if (color[i] == 0) {
//				System.out.print("Subgraph #" + count + ": ");
//				count++;
//				printRecursiveDFS(i, color);
//				System.out.println();
//			}
//		}

	}

	private void printRecursiveDFS(int u, int[] color) {
		if (color[u] != 1) {
			System.out.print(u + " ");
			color[u] = 1;
		}
		for (int v : this.adjacencyList.get(u)) {
			if (color[v] == 0) {
				printRecursiveDFS(v, color);
			}
		}
	}

	public void printBFS() {
		System.out.println("Graph BFS: ");
		int n = countVertices();
		int[] color = new int[n];

		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (color[i] == 0) {
				System.out.print("Subgraph #" + count + ": ");
				q.add(i);
				color[i] = 1;
				while (!q.isEmpty()) {
					int curV = q.poll();
					color[curV] = 2;
					System.out.print(curV + " ");
					for (int neighbor : this.adjacencyList.get(curV)) {
						if (color[neighbor] == 0) {
							q.add(neighbor);
							color[neighbor] = 1;
						}
					}
				}
				System.out.println();

			}
		}

	}

}
