
public class RotateMatrix {
//	Given an image represented by an NxN matrix, where each pixel in the image is 4
//	bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

	public static void main(String[] args) {
		int[][] image = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// I will write the solution for rotating this image 90 degrees clockwise
		rotateImage(image);

	}

	private static void rotateImage(int[][] a) {
		int n = a.length;

		int i = 0;
		
		while (i < Math.ceil((double) n / 2)) {

			for (int j = i; j < n - i - 1; j++) {
				int temp = a[i][j];

				// left to top
				a[i][j] = a[n - 1 - i][j];

				// bottom to left
				a[n - 1 - i][j] = a[n - 1 - i][n - 1 - j];

				// right to bottom
				a[n - 1 - i][n - 1 - j] = a[i][n - 1 - j];

				// top to right
				a[i][n - 1 - j] = temp;
			}
			i++;
		}

		for (i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
