package lintcode;

public class P38_Search_a_2D_Matrix_II {

	public static void main(String[] args) {

		int s[][] = { { 1, 3, 5, 7 }, { 2, 4, 7, 8 }, { 3, 5, 9, 10 } };

		System.out.println(searchMatrix(s, 3));

	}

	public static int searchMatrix(int[][] matrix, int target) {

		int i = matrix.length - 1, j = 0;

		int counter = 0;

		while (i >= 0 && j < matrix[0].length) {

			if (matrix[i][j] == target) {
				counter++;
				j++;
			} else if (matrix[i][j] < target) {
				j++;
			} else {
				i--;
			}
		}

		return counter;
	}
}
