
public class BinaryTree {

	public BinaryNode root;

	public BinaryTree(int data) {
		this.root = new BinaryNode(data);
	}

	public void inOrderTraversal() {
		BinaryNode cur = this.root;
		System.out.println("InOrder Traversal: ");
		inOrderTraversal(cur);
		System.out.println("\n");
	}

	public void preOrderTraversal() {
		BinaryNode cur = this.root;
		System.out.println("PreOrder Traversal: ");
		preOrderTraversal(cur);
		System.out.println("\n");

		
	}

	public void postOrderTraversal() {
		BinaryNode cur = this.root;
		System.out.println("PostOrder Traversal: ");
		postOrderTraversal(cur);
		System.out.println("\n");
	}

	private void inOrderTraversal(BinaryNode node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	private void preOrderTraversal(BinaryNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	private void postOrderTraversal(BinaryNode node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}
	

}

class BinaryNode {
	public int data;
	public BinaryNode left, right;

	public BinaryNode(int data) {
		this.data = data;

	}

	public BinaryNode(int data, BinaryNode l, BinaryNode r) {
		this.data = data;
		this.left = l;
		this.right = r;
	}

}