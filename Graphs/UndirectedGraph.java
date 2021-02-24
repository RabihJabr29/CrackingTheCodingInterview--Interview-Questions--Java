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
		int[] visited = new int[n];

		// you can change the source, however, usually it starts 
		// from the lowest numbered vertex
		int src = 0;
		
		// you can use this assuming that the graph is a connected graph.
		printRecursiveDFS(src, visited);

		// if the graph is not a connected graph you can run the below code.
		// just remove the //s

//		int count = 0;
//		for (int i = 0; i < n; i++) {
//			if (visited [i] == 0) {
//				System.out.print("Subgraph #" + count + ": ");
//				count++;
//				printRecursiveDFS(i, visited );
//				System.out.println();
//			}
//		}

	}

	private void printRecursiveDFS(int src, int[] visited ) {
		if (visited [src] != 1) {
			System.out.print(src + " ");
			visited [src] = 1;
		}
		for (int vertex : this.adjacencyList.get(src)) {
			if (visited [vertex] == 0) {
				printRecursiveDFS(vertex, visited );
			}
		}
	}

	public void printBFS() {
		System.out.println("Graph BFS: ");
		int n = countVertices();
		int[] visited = new int[n];

		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				System.out.print("Subgraph #" + count + ": ");
				q.add(i);
				visited[i] = 1;
				while (!q.isEmpty()) {
					int currenyVertex = q.poll();
					visited[currenyVertex] = 2;
					System.out.print(currenyVertex + " ");
					for (int neighbor : this.adjacencyList.get(currenyVertex)) {
						if (visited[neighbor] == 0) {
							q.add(neighbor);
							visited[neighbor] = 1;
						}
					}
				}
				System.out.println();

			}
		}

	}

}
