
public class DeleteMiddleNode {

//	Implement an algorithm to delete a node in the middle (i.e., any node but
//	the first and last node, not necessarily the exact middle) of a singly linked
//	list, given only access to that node.

	public static void main(String[] args) {
		MyLinkedList l = MyLinkedList.createRandomLinkedList(10);

		System.out.println(removeMiddleNode(l, l.getHead().next.next));
		System.out.println(removeMiddleNode(l, l.getHead()));

	}

	private static boolean removeMiddleNode(MyLinkedList l, Node cur) {
		// checking if this is the first or the last element of the linked list.
		if (cur == null || cur.next == null) {
			return false;
		}
		// to remove the current node, we can assign to it the next node's attributes
		l.removeNode(cur);
		return true;
	}
}
