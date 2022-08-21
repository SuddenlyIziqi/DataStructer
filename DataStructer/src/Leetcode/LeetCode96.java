
package Leetcode;

/**
 * 96. 不同的二叉搜索树
 */
public class LeetCode96 {
    public static void main(String[] args) {

    }

    //curr[i] = dp[i-1]*dp[n-i];
    //dp[i] = dp[i-1]+dp[i-1]*dp[n-i];
    //给定一个有序序列
    //1⋯n，为了构建出一棵二叉搜索树，我们可以遍历每个数字
    //i，将该数字作为树根，将
    //1⋯(i−1) 序列作为左子树，
    //(i+1)⋯n 序列作为右子树。接着我们可以按照同样的方式递归构建左子树和右子树。

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
