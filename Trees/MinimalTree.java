
public class MinimalTree {

//	Given a sorted (increasing order) array with unique integer elements, 
//	write an algorithm to create a binary search tree with minimal height.
	
	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };

		BSTNode minimalBST = createMinimalBinarySearchTree(numbers, 0, numbers.length-1);

		inOrderTraversal(minimalBST);
	}

	public static BSTNode createMinimalBinarySearchTree(int data[], int i, int j) {
		// since we should have a minimal BST, we should have almost same 
		// number of nodes on the left and the right. this is why we 
		// are going to choose the middle element of each subarray to be the root
		// of each subtree.
		if (i > j) {
			return null;
		}
		int mid = (i + j) / 2;
		BSTNode node = new BSTNode(data[mid]);
		node.left = createMinimalBinarySearchTree(data, i, mid - 1);
		node.right = createMinimalBinarySearchTree(data, mid + 1, j);
		return node;
	}

	private static void inOrderTraversal(BSTNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}
}

class BSTNode {
	int data;
	BSTNode left, right;

	public BSTNode(int data) {
		this.data = data;
	}
}
