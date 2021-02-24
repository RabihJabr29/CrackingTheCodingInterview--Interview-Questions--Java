
public class CheckBalanced {
//	Implement a function to check if a binary tree is balanced. For the 
//	purposes of this question, a balanced tree is defined to be a tree 
//	such that the heights of the two subtrees of any node never differ
//	by more than one. 
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

		BinaryNode node = bt.root;
		if (isBalanced(node)) {
			System.out.println("This tree is balanced");
		} else {
			System.out.println("This tree is not balanced");
		}
	}

	public static boolean isBalanced(BinaryNode root) {
		// we can just check if each subtree is balanced.
		// of course we have to use the height of each subtree, so we created
		// height() function.
		if (root == null) {
			return true;
		} else {
			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftHeight - rightHeight) <= 1;
		}
	}

	public static int height(BinaryNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(height(root.left), height(root.right));
	}
}
