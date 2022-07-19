package CodingInterviewChinese2;

public class P29_PrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        printMatrix(matrix, 4, 4);
        System.out.println();

        int[][] matrix2 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {10, 11, 12, 13, 14},
                {14, 15, 16, 17, 18},
        };
        printMatrix(matrix2, 4, 5);
        System.out.println();
    }

    static void printMatrix(int[][] matrix, int rows, int cols) {
        int n     = matrix.length;
        int r = 0;
        for (r = 0; r * 2 < rows && r * 2 < cols; r++) {
            print(matrix, rows, cols, r);
        }
    }

    static void print(int[][] matrix, int rows, int cols, int r) {
        int endRow = rows - 1 - r;
        int endCol = cols - 1 - r;

        //left -> right
        for (int i = r; i <= endCol; i++) {
            print(matrix[r][i]);
        }

        //up -> low
        for (int i = r + 1; i <= endRow; i++) {
            print(matrix[i][endCol]);
        }

        //right -> left
        for (int i = endCol - 1; i >= r; i--) {
            print(matrix[endRow][i]);
        }

        //low -> up
        for (int i = endRow - 1; i >= r + 1; i--) {
            print(matrix[i][r]);
        }
    }

    static void print(int m) {
        System.out.print(m + " ");
    }
}
