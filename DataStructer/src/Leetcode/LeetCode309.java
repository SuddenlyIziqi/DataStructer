package Leetcode;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class LeetCode309 {
    public static void main(String[] args) {

    }

    /**
     * 第i天的收益有三种状态
     * 1.第i天结束持有一只股票  （可能是昨天买入的，也可能是昨天没有但是第i天（可以）买入的）第i天对应最大收益 dp[i][0] = dp[i-1][0]或者dp[i-1][2]-prices[i];
     * 2.第i天结束没有持有股票，并且第i天结束处于冷冻期间(也就是第i天卖了，) 对应最大收益 dp[i][1] = dp[i-1][0] + price[i]
     * 3.第i天结束没有持有股票，并且第i天结束不处于冷冻期间（也就是昨天或者之前就卖掉了） 对应最大收益 dp[i][2] = dp[i-1][1] 或者dp[i-1][2]
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[length - 1][1], dp[length - 1][2]);
    }
}
