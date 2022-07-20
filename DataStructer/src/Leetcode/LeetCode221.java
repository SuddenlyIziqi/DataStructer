package Leetcode;

/**
 *221. 最大正方形
 */
public class LeetCode221 {
    public static void main(String[] args) {
        LeetCode221 leetCode221 = new LeetCode221();
        char[][] ints = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        leetCode221.maximalSquare(ints);

    }
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){return 0;}
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp =  new int[rows][cols];
        dp[0][0] = 0;
        int maxSide = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j]=='1'){
                    if(i==0||j==0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = getMin(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }
    public int getMin(int...ints){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            min = Math.min(min,ints[i]);
        }
        return min;
    }

}
