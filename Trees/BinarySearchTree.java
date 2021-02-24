// This is an extra class. here you can find a plenty of functions that might be 
// of a help for you.
public class BinarySearchTree {
	private Node root;

	public class Node {
		private Node right;
		private Node left;
		private int data; 

		public Node(Node left, Node right, int data) {
			super();
			this.right = right;
			this.left = left;
			this.data = data;
		}

		public Node(int key) {
			data = key;

		}

	}

	public boolean isEmpty() {
		return (root == null);
	}	

	public BinarySearchTree() {
		root = null;
	}

	public BinarySearchTree(int element) {
		this.root = new Node(null, null, element);
	}

	public BinarySearchTree(Node n) {
		this.root = n;
	}

	public BinarySearchTree(int elem, Node leftSubTree, Node rightSubTree) {
		root = new Node(null, null, elem);
		if (leftSubTree != null) {
			root.left = leftSubTree;
		}
		if (rightSubTree != null) {
			root.right = rightSubTree;
		}
	}

	public BinarySearchTree getLeftSubTree(Node root) {
		if (root == null)
			return new BinarySearchTree();
		else {
			if (root.left != null)
				return new BinarySearchTree(root.left);
			else
				return new BinarySearchTree();
		}
	}

	public BinarySearchTree getRightSubTree(Node root) {
		if (root == null)
			return new BinarySearchTree();
		else {
			if (root.right != null)
				return new BinarySearchTree(root.right);
			else
				return new BinarySearchTree();
		}
	}

	public boolean isLeaf(Node root) {
		return (root == null || (root.left == null && root.right == null));
	}

	public String toString() {
		return preOrder(root);
	}

	public String preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
		return "";
	}

	private Node add(Node root, int key) {
		if (root == null) {
			this.root = new Node(key);
		} else if (key < root.data) {
			if (root.left == null)
				root.left = new Node(key);
			else
				root.left = add(root.left, key);
		} else if (key > root.data) {
			if (root.right == null)
				root.right = new Node(key);
			else
				root.right = add(root.right, key);
		}
		return root;
	}

	public Node add(int key) {
		return add(root, key);
	}

	public Node getRoot() {
		return root;
	}

	public static int height(Node root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(height(root.left), height(root.right));
	}

	public int findMin(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		} else if (root.left == null)
			return root.data;
		else
			return findMin(root.left);
	}

	public int findMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		else if (root.right == null)
			return root.data;
		else
			return findMax(root.right);
	}

	public int getRootData() {
		return root.data;
	}

	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public int countLeaves(Node root) {
		if (root == null)
			return 0;
		else if (root.right == null && root.right == null)
			return 1;
		else
			return countLeaves(root.left) + countLeaves(root.right);
	}

	public int size(Node root) {
		if (root == null)
			return 0;
		else
			return 1 + size(root.left) + size(root.right);
	}

	public static boolean BTEqual(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 != null && root2 != null) {
			return (root1.data == root2.data && BTEqual(root1.left, root2.left) && BTEqual(root1.right, root2.right));
		}
		return false;
	}

	public int getMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int res = root.data;
		int lres = findMax(root.left);
		int rres = findMax(root.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

	public int width() {
		int max = 0;
		for (int i = 0; i < height(root); i++) {
			int x = width(root, i);
			if (x > max)
				max = x;
		}
		return max;
	}

	private int width(Node root, int depth) {
		depth = height(root);

		if (root == null)
			return 0;
		else if (depth == 1)
			return 1;
		else {
			return width(root.left, depth - 1) + width(root.right, depth - 1);
		}
	}

	public void printLevelOrder() {
		printLevelOrder(root);
	}

	private void printGivenLevel(Node cur, int level) {
		if (cur == null) {
			return;
		}
		if (level == 1)
			System.out.print(cur.data + " ");
		else if (level > 1) {
			printGivenLevel(cur.left, level - 1);
			printGivenLevel(cur.right, level - 1);
		}
	}

	private void printLevelOrder(Node root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
	}

	public void printSideWays() {
		printSideWays(root, "");
	}

	private void printSideWays(Node root, String indent) {
		if (root != null) {
			printSideWays(root.right, indent + " ");
			System.out.println(indent + root.data);
			printSideWays(root.left, indent + " ");
		}
	}

	
	public int sum(Node root) {
		if (root != null) {
			return root.data + sum(root.left) + sum(root.right);
		}
		return 0;
	}

	public void leftNodeNum(Node root) {
		if (root != null) {
			if (root.left != null) {
				System.out.println(root.left.data);
			}
			leftNodeNum(root.left);

			leftNodeNum(root.right);

		}
	}

	public void PosIntDouble(Node root) {
		if (root != null) {
			root.data = root.data * 2;
			PosIntDouble(root.left);
			PosIntDouble(root.right);
		}
	}

	public int countEmptyBranches(Node root) {
		if (root == null)
			return 1;
		else {
			return countEmptyBranches(root.left) + countEmptyBranches(root.right);
		}
	}

	private int getSumGivenLevel(Node root, int level) {
		if (root == null)
			return 0;
		if (level == 1) {
			return root.data;
		} else if (level > 1) {
			return getSumGivenLevel(root.left, level - 1) + getSumGivenLevel(root.right, level - 1);
		}
		return 0;
	}

	public int SumLevel(Node root) {
		int sum = 0;
		for (int i = 1; i <= height(root); i++) {
			sum += i * getSumGivenLevel(root, i);
		}
		return sum;
	}

	public void printLeavesRtoL(Node root) {
		if (root != null) {
			if (root.left == null && root.right == null)
				System.out.print(root.data + " ");
			printLeavesRtoL(root.right);
			printLeavesRtoL(root.left);
		}
	}

	public String toStringStruct(Node root) {
		if (root == null) {
			return "empty";
		} else if (root.left == null && root.right == null) {
			return "" + root.data;
		} else {
			return "(" + root.data + "," + toStringStruct(root.left) + ","
						+ toStringStruct(root.right) + ")";
		}
	}

	public void printAllPaths(Node root, int[] paths, int index) {
		if (root == null)
			return;
		else {

			paths[index] = root.data;
			index++;

			if (root.left == null && root.right == null) {
				for (int i = 0; i < index; i++) {
					System.out.print(paths[i] + " ");
				}
				System.out.println();
			} else {
				printAllPaths(root.left, paths, index);
				printAllPaths(root.right, paths, index);
			}
		}
	}

	public boolean isBalanced(Node root) {
		if (root == null)
			return true;

		else {
			return isBalanced(root.left) && isBalanced(root.right) && height(root.left) - height(root.right) <= 1;
		}
	}

	public int countBranches(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 2;
		} else if (root.left == null && root.right != null) {
			return 1 + countBranches(root.right);
		} else if (root.left != null && root.right == null) {
			return 1 + countBranches(root.left);
		} else
			return countBranches(root.left) + countBranches(root.right);
	}
}