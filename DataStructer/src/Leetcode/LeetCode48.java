package Leetcode;

/**
 * 48. 旋转图像
 */
public class LeetCode48 {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //水平翻转
        for (int i = 0; i < (rows / 2); i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] ^= matrix[rows - 1 - i][j];
                matrix[rows - 1 - i][j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[rows - 1 - i][j];
            }
        }

        //主对角线翻转
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i != j) {
                    matrix[i][j] ^= matrix[j][i];
                    matrix[j][i] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[j][i];
                }
            }
        }


    }

    void swap(int[][] matrix, int i, int j) {

    }
}
