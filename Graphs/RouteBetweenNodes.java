import java.util.*;

public class RouteBetweenNodes {

//	Given a directed graph, design an algorithm to find out whether there is a
//	route between two nodes. 
	
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	public static void main(String[] args) {
		// we can use both dfs or bfs to traverse the graph.
		// here I am using dfs, try on your own to use bfs.
		
		
		// before running the program, try to draw the graph and play with it.
		// PS: notice that this is a directed graph
		// think about a solution for undirected graphs.
		int n = 5;
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(2).add(4);
		adj.get(3).add(1);
		adj.get(4).add(3);

		// node1 and node2 are the two nodes we are checking for path between them.
		int node1 = 0, node2 = 4;

		int[] visited = new int[n];
		if (dfs(node1, node2, visited)) {
			System.out.println("There is a path between " + node1 + " and " + node2 + ".");
		} else {
			System.out.println("There is no path between " + node1 + " and " + node2 + ".");
		}
	}

	private static boolean dfs(int src, int dest, int[] visited) {
		if (visited[src] != 1) {
			visited[src] = 1;
		}
		for (int vertex : adj.get(src)) {
			if (visited[vertex] == 0) {
				dfs(vertex, dest, visited);
			}
		}
		return visited[dest] == 1;
	}
}
