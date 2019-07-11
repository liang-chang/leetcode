package lintcode;

public class P109_Triangle {

	public static void main(String[] args) {

		System.out.println(minimumTotal(new int[][] { { 2 }, { 3, 4 },
				{ 6, 5, 7 }, { 4, 1, 8, 3 } }));

		System.out.println(minimumTotal(new int[][] { { 2 }, { 3, 2 },
				{ 6, 5, 7 }, { 4, 4, 8, 1 } }));

	}

	/**
	 * @param triangle
	 *            : a list of lists of integers
	 * @return: An integer, minimum path sum
	 */
	public static int minimumTotal(int[][] triangle) {

		if (triangle.length <= 0) {
			return 0;
		}

		int[][] minMum = new int[triangle.length][triangle[triangle.length - 1].length];

		minMum[0][0] = triangle[0][0];

		for (int i = 1, rowLen = triangle.length; i < rowLen; i++) {
			for (int j = 0, colLen = triangle[i].length; j < colLen; j++) {
				if (j == 0) {
					minMum[i][j] = triangle[i][j] + minMum[i - 1][j];
				} else if (j == colLen - 1) {
					minMum[i][j] = triangle[i][j] + minMum[i - 1][j - 1];
				} else {
					int a = triangle[i][j] + minMum[i - 1][j - 1];
					int b = triangle[i][j] + minMum[i - 1][j];
					minMum[i][j] = Math.min(a, b);
				}
			}
		}

		int[] array = minMum[triangle.length - 1];
		int min = array[0];
		for (int i = 1, len = array.length; i < len; i++) {
			min = min < array[i] ? min : array[i];
		}

		return min;
	}
}
