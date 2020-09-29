package leetcode;

import java.util.ArrayList;
import java.util.List;

class P374_Spiral_Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));

        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix2));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int           rows = matrix.length;
        int           cols = matrix[0].length;
        List<Integer> ret  = new ArrayList<>(rows * cols);

        int round = 0;
        for (int i = 0; i <= rows / 2; i++) {
            print(matrix, ret, rows, cols, round);
            round++;
        }

        return ret;
    }

    /*
     *
     *
     */
    public static List<Integer> print(int[][] matrix, List<Integer> ret, int rows, int cols, int round) {

        int endRow = rows - round - 1;
        int endCol = cols - round - 1;

        //左 -> 右 ,行相同
        for (int i = round; i <= endCol; i++) {
            ret.add(matrix[round][i]);
        }

        //右 -> 下 ,列相同
        if (round < endRow) {
            for (int i = round + 1; i <= endRow; i++) {
                ret.add(matrix[i][endCol]);
            }
        }

        //右 -> 左 ,行相同
        if (round < endCol && endRow > round) {
            for (int i = endCol - 1; i >= round; i--) {
                ret.add(matrix[endRow][i]);
            }
        }

        //下 -> 上 ,列相同
        if (round < endRow - 1 && round >= 0) {
            for (int i = endRow - 1; i >= round + 1; i--) {
                ret.add(matrix[i][round]);
            }
        }

        return ret;
    }
}
