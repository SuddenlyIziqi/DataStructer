package Leetcode;

/**
 * 64. 最小路径和
 */
public class LeetCode64 {
    public static void main(String[] args) {

    }

    //dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])) + grid[i][j]
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        //dp[0][0]
        dp[0][0] = grid[0][0];
        //第一行的dp
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //第一列的dp
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //非第一行第一列
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
