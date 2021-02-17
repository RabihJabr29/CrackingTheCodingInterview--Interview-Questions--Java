
public class MyLinkedList {

	private Node head;
	private int size;

	public int getSize() {
		return this.size;
	}

	public void setSize(int s) {
		this.size = s;
	}

	public Node getHead() {
		return this.head;
	}

	public MyLinkedList() {
		head = null;
		size = 0;
	}

	public MyLinkedList(int data) {
		head = new Node(data);
		size = 1;
	}

	public void add(int data) {
		if (head == null) {
			head = new Node(data);
			size = 1;
			return;
		}

		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new Node(data);
		size++;
	}

	public void displayLinkedList() {
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static MyLinkedList createRandomLinkedList(int size) {
		MyLinkedList l = new MyLinkedList();
		l.setSize(size);
		for (int i = 0; i < size; i++) {
			l.add((int) (Math.random() * 10));
		}

		return l;
	}

	public void addFirst(int data) {
		if (head == null) {
			head = new Node(data);
			size = 1;
			return;
		}
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public Node removeNode(Node cur) {
		if (cur != null) {
			Node next = cur.next;
			if (next == null) {
				removeLastNode();
				return null;
			} else {
				cur.next = next.next;
				cur.data = next.data;
			}
			return cur;
		}
		return null;
	}

	private boolean removeLastNode() {
		if (head == null) {
			return false;
		}
		Node cur = head;
		Node prev = null;
		int index = 0;
		while (cur.next != null) {
			prev = cur;
			cur = cur.next;
		}
		prev.next = null;
		return true;
	}

}
