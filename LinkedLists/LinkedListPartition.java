
public class LinkedListPartition {

//	Write code to partition a linked list around a value x, such that all nodes
//	less than x come before all nodes greater than or equal to x. If x is contained
//	within the list, the values of x only need to be after the elements less than
//    x (see below). The partition element x can appear anywhere in the
//	"right partition"; it does not need to appear between the left and right 
//    partitions.

	public static void main(String[] args) {
		MyLinkedList list = MyLinkedList.createRandomLinkedList(10);

		System.out.println("Original List");
		list.displayLinkedList();

		int k = 4;
		partitionLinkedList(list, k);
	}

	private static void partitionLinkedList(MyLinkedList list, int k) {
		Node cur = list.getHead();

		while (cur != null) {
			if (cur.data < k) {
				// Here I am using two method, addfirst() and removenode() 
				// that i implemented in the class MyLinkedList
				
				list.addFirst(cur.data);
				// to remove current node and get the next node
				cur = list.removeNode(cur);
			} else {
				cur = cur.next;
			}
		}
		System.out.println("After Partition with k=" + k);
		list.displayLinkedList();
	}

}
