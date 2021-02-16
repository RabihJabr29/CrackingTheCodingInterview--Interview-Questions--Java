import java.util.ArrayList;

public class ZeroMatrix {
//	Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//	column are set to 0. 

	public static void main(String[] args) {
		int[][] a1 = { { 1, 2, 0 }, { 1, 4, 4 }, { 3, 2, 0 } };

		int m = a1.length, n = a1[0].length;

		displayMatrix(a1);

		// here we are using storage for storing lists of rows and cols.
		performZeroMatrixBasic(a1, m, n);

		int[][] a2 = { { 1, 2, 0 }, { 1, 4, 4 }, { 3, 2, 0 } };
		int m2 = a2.length, n2 = a2[0].length;

		// here we are using O(1) extra space.
		performZeroMatrixAdvanced(a2, m2, n2);

	}

	private static void displayMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void performZeroMatrixBasic(int[][] a, int m, int n) {
		// I will be storing the numbers of rows and cols in which their elements
		// should be replaced by zeros in two array lists.
		// doing so will prevent the whole matrix to be a zero matrix

		ArrayList<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for (int row : rows) {
			for (int col = 0; col < n; col++) {
				a[row][col] = 0;
			}
		}
		for (int row = 0; row < m; row++) {
			for (int col : cols) {
				a[row][col] = 0;
			}
		}

		System.out.println("After calling the method");
		displayMatrix(a);
	}

	private static void performZeroMatrixAdvanced(int[][] a, int m, int n) {
		// to be implemented
		
		
	}
}
