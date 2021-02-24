import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
	
//	Given a binary tree, design an algorithm which creates a linked list of all 
//	the nodes at each depth (e.g., if you have a tree with depth D, 
//	you'll have D linked lists). 
	
	static ArrayList<LinkedList<Integer>> lists;

	public static void main(String[] args) {
		// Before you run this program try to draw this tree as it was created.
		// Feel free to create and try other trees. or play with the current tree.

		BinaryTree bt = new BinaryTree(1);
		bt.root.left = new BinaryNode(2);
		bt.root.left.left = new BinaryNode(3);
		bt.root.left.right = new BinaryNode(4);
		bt.root.right = new BinaryNode(5);
		bt.root.right.left = new BinaryNode(11);
		bt.root.right.right = new BinaryNode(6);
		bt.root.right.right.left = new BinaryNode(7);
		bt.root.right.right.right = new BinaryNode(8);

		lists = new ArrayList<>();
		int n = bt.size();
		for (int i = 0; i < n; i++) {
			lists.add(new LinkedList<Integer>());
		}
		BinaryNode node = bt.root;
		int level = 0;
		populateListsWithDepths(node, level);

		for (int i = 0; i < n; i++) {
			if (!lists.get(i).isEmpty()) {
				System.out.print("At level " + i + ": ");
				for (int d : lists.get(i)) {
					System.out.print(d + " ");
				}
				System.out.println();
			}
		}
	}

	private static void populateListsWithDepths(BinaryNode node, int level) {
		// it is kinda clear that we can do an Inorder traversal while adding
		// a new parameter level to indicate the current level of the node.
		// then we add each node data to its corresponding linked list.
		if (node != null) {
			lists.get(level).add(node.data);
			populateListsWithDepths(node.left, level+1);
			populateListsWithDepths(node.right, level+1);
		}
	}
}
