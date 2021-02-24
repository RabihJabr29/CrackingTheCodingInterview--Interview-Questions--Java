import java.util.Scanner;

class HeapNode implements Comparable<HeapNode> {
	int data;
	int degree;

	public HeapNode(int u, int degree) {
		this.data = u;
		this.degree = degree;
	}

	public HeapNode(HeapNode h) {
		this.data = h.data;
		this.degree = h.degree;
	}

	public int compareTo(HeapNode o) {
		return degree - o.degree;
	}
}

public class MinHeap {
	int size;
	HeapNode[] a;

	public MinHeap(int n) {
		size = 0;
		a = new HeapNode[n];
	}

	public void insert(int value, int degree) {
		a[size] = new HeapNode(value, degree);
		int i = size;
		while (i > 0 && a[i].compareTo(a[(i - 1) / 2]) < 0) {
			swap(i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
		size++;
	}

	public void swap(int i, int j) {
		HeapNode temp = new HeapNode(a[i]);
		a[i] = a[j];
		a[j] = temp;
	}

	public HeapNode extractMin() {
		HeapNode max = a[0];
		swap(0, size - 1);
		size--;
		int i = 0;
		while (true) {
			if (2 * i + 2 >= size) {
				if (2 * i + 1 >= size)
					return max;
				if (a[2 * i + 1].compareTo(a[i]) < 0) {
					swap(i, 2 * i + 1);
				}
				return max;
			}
			if (a[2 * i + 1].compareTo(a[2 * i + 2]) < 0) {
				if (a[2 * i + 1].compareTo(a[i]) < 0) {
					swap(i, 2 * i + 1);
					i = 2 * i + 1;
				} else
					return max;
			} else {
				if (a[2 * i + 2].compareTo(a[i]) < 0) {
					swap(i, 2 * i + 2);
					i = 2 * i + 2;
				} else
					return max;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MinHeap mh = new MinHeap(4);
		for (int i = 0; i < 4; i++) {
			mh.insert(scan.nextInt(), scan.nextInt());
		}
		System.out.println(mh.extractMin().data);
	}
}
