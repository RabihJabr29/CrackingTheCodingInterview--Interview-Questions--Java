
public class BinaryTreeDriver {

	public static void main(String[] args) {
	
		// Before you run this program try to draw this tree as it was created.
		// Feel free to create and try other trees.
		
		BinaryTree bt = new BinaryTree(1);
		bt.root.left = new BinaryNode(2);
		bt.root.left.left = new BinaryNode(3);
		bt.root.left.right = new BinaryNode(4);
		bt.root.right = new BinaryNode(5);
		bt.root.right.left = new BinaryNode(11);
		bt.root.right.right = new BinaryNode(6);
		bt.root.right.right.left = new BinaryNode(7);
		bt.root.right.right.right = new BinaryNode(8);

		bt.inOrderTraversal();
		
		bt.preOrderTraversal();
		
		bt.postOrderTraversal();
	}

}
