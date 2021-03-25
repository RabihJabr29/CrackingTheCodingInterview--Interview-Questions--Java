
public class UndirectedGraphDriver {

	public static void main(String[] args) {
		// Notice that vertices in this graph are zero based numbered.
		UndirectedGraph graph = new UndirectedGraph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		
		// remove this comment in order for the graph to be a connected graph.
//		graph.addEdge(2, 4);
		
		graph.printRecursiveDFS();
		
		graph.printBFS(2);
	}

}
