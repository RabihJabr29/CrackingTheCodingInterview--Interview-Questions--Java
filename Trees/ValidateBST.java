
public class ValidateBST {
//	Implement a function to check if a binary tree is a binary search tree. 
	public static void main(String[] args) {
		// Before you run this program try to draw this tree as it was created.
		// Feel free to create and try other trees.

		BinaryTree bt1 = new BinaryTree(1);
		bt1.root.left = new BinaryNode(2);
		bt1.root.left.left = new BinaryNode(3);
		bt1.root.right = new BinaryNode(4);

		BinaryTree bt2 = new BinaryTree(3);
		bt2.root.left = new BinaryNode(2);
		bt2.root.left.left = new BinaryNode(1);
		bt2.root.right = new BinaryNode(6);
		bt2.root.right.left = new BinaryNode(5);
		bt2.root.right.right = new BinaryNode(7);

		BinaryNode node1 = bt1.root;
		if (isBST(node1)) {
			System.out.println("BT1 is a binary search tree.");
		} else {
			System.out.println("BT1 is not a binary search tree.");
		}
		BinaryNode node2 = bt2.root;
		if (isBST(node2)) {
			System.out.println("BT2 is a binary search tree.");
		} else {
			System.out.println("BT2 is not a binary search tree.");
		}
	}

	private static boolean isBST(BinaryNode node) {
		if (node == null) {
			return true;
		}
		if (node.left != null && node.left.data > node.data) {
			return false;
		}
		if (node.right != null && node.right.data < node.data) {
			return false;
		}
		return isBST(node.left) && isBST(node.right);
	}
}
