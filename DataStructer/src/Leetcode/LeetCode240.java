package Leetcode;

/**
 *
 */
public class LeetCode240 {
    public static void main(String[] args) {

    }

    /**
     * 方法一，直接遍历
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length <= 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二 逐行二分法
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            int index = search2(matrix[i], target);
            if (index > 0) {
                return true;
            }
        }
        return false;
    }

    public int search2(int[] row, int target) {
        if (row == null || row.length <= 0) return -1;
        int length = row.length;
        int l = 0;
        int r = length - 1;
        int mid = l + r / 2;
        while (l <= r) {
            if (row[mid] == target) {
                return 1;
            } else if (row[mid] < target) {
                l = mid - 1;
            } else {
                r = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 方法三  Z字形扫描法
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols - 1;

        while (i < rows && j > 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
