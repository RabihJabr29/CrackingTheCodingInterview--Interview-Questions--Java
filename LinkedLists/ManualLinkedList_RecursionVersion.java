// This is an extra linked list manual version. here you can find plenty of
// methods that might be of a help for you.
public class ManualLinkedList_RecursionVersion {
	private int size = 0;
	private Node head;
	private Node tail;

	private class Node {
		protected String data;
		protected Node next;

		public Node(String data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void addFirst(String s) {
		if (isEmpty()) {
			head = new Node(s, null);
			size++;
		} else {
			Node newnode = new Node(s, head.next);
			newnode.next = head;
			head = newnode;

			size++;
		}
	}

	public void addLast(String s) {
		if (isEmpty()) {
			addFirst(s);
		} else {
			add(head, s);
		}
	}

	private void add(Node cur, String s) {
		if (cur.next == null) {
			cur.next = new Node(s, null);
		} else {
			add(cur.next, s);
		}
		size++;
	}

	private boolean removeRec(Node cur, Node prev, String s) {
		if (cur == null) {
			return false;
		} else {
			if (cur.data.equals(s)) {
				prev.next = cur.next;
				size--;
				return true;
			} else {
				return removeRec(cur.next, head, s);
			}
		}
	}

	public boolean remove(String s) {
		if (head == null) {
			return false;
		} else if (head.data.equals(s)) {
			head = head.next;
			size--;
			return true;
		} else {
			return removeRec(head.next, head, s);
		}
	}

	private void replace(Node cur, String olds, String news) {
		if (head != null) {
			if (cur.data.equals(olds)) {
				cur.data = news;
			}
			if (cur.next != null)
				replace(cur.next, olds, news);
		}
	}

	public void replace(String olds, String news) {
		replace(head, olds, news);
	}

	public boolean removeFirst() {
		if (head == null) {
			return false;
		} else {
			head = head.next;
			size--;
			return true;
		}
	}

	public boolean removeLast() {
		if (head == null) {
			return false;
		} else if (size == 1) {
			head = null;
			size--;
			return true;
		} else {
			traverseDelete(head.next, head);
			return true;
		}
	}

	private void traverseDelete(Node cur, Node prev) {
		if (cur.next == null) {
			prev.next = null;
			size--;
		} else {
			traverseDelete(cur.next, prev.next);
		}
	}

	public String toString() {
		return toString(head);
	}

	public String toString(Node cur) {
		if (cur == null)
			return "";
		else {
			return cur.data + ", " + toString(cur.next);
		}
	}

	public void insertBefore(String target, String s) {
		if (head == null)
			addFirst(s);
		else if (size == 1) {
			if (head.data.equals(target)) {
				addFirst(s);
			}
		} else if (head.data.equals(target)) {
			addFirst(s);
		} else {
			insertBeforeRec(head.next, head, target, s);
		}
	}

	private void insertBeforeRec(Node cur, Node prev, String target, String s) {
		Node newnode = new Node(s, null);
		if (cur.data.equals(target)) {
			newnode.next = cur;
			prev.next = newnode;
			size++;
		} else {
			insertBeforeRec(cur.next, cur, target, s);
		}
	}

	public void insertAfter(String target, String s) {
		if (head == null)
			addFirst(s);
		else if (size == 1) {
			if (head.data.equals(target)) {
				addLast(s);
			}
		} else {
			insertAfterRec(head, head.next, target, s);
		}
	}

	private void insertAfterRec(Node cur, Node nextnode, String target, String s) {
		Node newnode = new Node(s, null);
		if (cur.data.equals(target)) {
			newnode.next = nextnode;
			cur.next = newnode;
			size++;
		} else {
			insertAfterRec(nextnode, nextnode.next, target, s);
		}
	}

	public void reverseRecursive() {
		Node oldHead = head;
		reverseRecursiveHelper(head);
		head = tail; // swap head and tail
		tail = oldHead; //

	}

	private void reverseRecursiveHelper(Node cur) {
		if (cur.next == null) {
			return;
		}
		Node sec = cur.next;
		Node temp = sec.next;
		sec.next = cur;
		cur.next = null;
		tail = sec;
		if (temp != null)
			reverseRecursiveHelper(temp);
	}
}



