
public class ReturnKthToLast {
	// Implement an algorithm to find the kth to last element of a singly linked
	// list

	public static void main(String[] args) {

		MyLinkedList l = MyLinkedList.createRandomLinkedList(10);

		l.displayLinkedList();

		int k = 4;

		// Basic solution
		System.out.println("Basic Solution");
		kthToLast(l, k);

		System.out.println("Recursively");
		kthToLastRecursive(l.getHead(), k);
	}

	private static void kthToLast(MyLinkedList l, int k) {

		Node cur = l.getHead();
		if (cur == null) {
			System.out.println("Linked list is empty.");
			return;
		}
		int index = 0;
		while (index < l.getSize() - k) {
			cur = cur.next;
			index++;
		}
		System.out.println(k + "th to last element is " + cur.data);

	}

	private static int kthToLastRecursive(Node cur, int k) {
		if (cur == null) {
			return 0;
		}
		int index = kthToLastRecursive(cur.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last element is " + cur.data);
		}
		return index;
	}
}