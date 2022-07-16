package Leetcode;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class LeetCode279 {
    public static void main(String[] args) {
        LeetCode279 leetCode279 = new LeetCode279();

        int n = 12;
        int[] ints = leetCode279.get(n);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
        int dp = leetCode279.dp(n);
        System.out.println("dp = " + dp);
        int i = leetCode279.numSquares(n);
        System.out.println("i = " + i);
    }

    //1.获取整数 n 可能的组合 也就是 从 1，4，9....都在 n内，
    public int[] get(int n) {
        int[] arr = new int[10];
        for (int i = 1; i * i <= n; i++) {
            arr[i - 1] = i * i;
        }
        return arr;
    }
    //2.针对上面获取的组合 成了 零钱问题

    public int dp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;

        }
        return dp[n];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

}
