import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class RemoveDups {

//	Write code to remove duplicates from an unsorted linked list.
//	FOLLOW UP
//	How would you solve this problem if a temporary buffer is not allowed?

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		for (int i = 0; i < 20; i++) {
			int r = (int) ((double) Math.random() * 10);
			l.add(r);
		}

		ListIterator<Integer> iter = l.listIterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();

		System.out.println("Using Basic Approach by utilising a set. ");
		// we have a time complexity of O(n) space complexity of O(n)
		// where n is the number of the unique numbers
		removeDups(l);

		// we can also create another algorithm using 2 pointer but it would have
		// O(n) time complexity and O(1) space complexity
	}

	private static void removeDups(LinkedList<Integer> l) {

		HashSet<Integer> hs = new HashSet<>();

		ListIterator<Integer> iter = l.listIterator();
		iter = l.listIterator();
		while (iter.hasNext()) {
			int x = iter.next();
			if (hs.contains(x)) {
				iter.remove();
			} else {
				hs.add(x);
			}
		}
		iter = l.listIterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

	

}
