package Leetcode;

/**
 * 70. 爬楼梯
 */
public class LeetCode70 {
    public static void main(String[] args) {
        LeetCode70 leetCode70 = new LeetCode70();
        leetCode70.climbStairs(1);
    }

    //dp[i] = dp[i-1] + dp[i-2]
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
