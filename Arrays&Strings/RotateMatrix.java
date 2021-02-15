
public class RotateMatrix {
//	Given an image represented by an NxN matrix, where each pixel in the image is 4
//	bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

	public static void main(String[] args) {
		int[][] image = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// I will write the solution for rotating this image 90 degrees
		// clockwise and anti-clockwise

		// clockwise
		rotateImage(image);

		int[][] image2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// anti-clockwise
		rotateImageACC(image2);
	}

	private static void rotateImage(int[][] a) {
		int n = a.length;

		int i = 0;

		for (i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = a[i][j]; // 2

				// left to top
				a[i][j] = a[n - 1 - j][i]; // 2 = 4

				// bottom to left
				a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j]; // 4 =

				// right to bottom
				a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];

				// top to right
				a[j][n - 1 - i] = temp;
			}
			i++;
		}

		System.out.println("Image rotated clockwise");

		for (i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void rotateImageACC(int[][] a) {
		int n = a.length;

		int i = 0;

		for (i = 0; i < n / 2; i++) {

			for (int j = i; j < n - i - 1; j++) {
				int temp = a[i][j];

				// right to top
				a[i][j] = a[j][n - 1 - i];

				// bottom to right
				a[j][n - 1 - i] = a[n - 1 - i][n - 1 - j];

				// left to bottom
				a[n - 1 - i][n - 1 - j] = a[n - 1 - j][i];

				// temp to left
				a[n - 1 - j][i] = temp;
			}
		}

		System.out.println("Image rotated Anti-clockwise");
		for (i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}
}
