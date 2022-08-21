package Leetcode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 中国人寿终面笔试遇到过
 * 给以个理财产品收益列表   给一个 aim 要得出最少需要买多少份理财
 */
public class LeetCode322 {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

//        for (int coin : coins) {
//            dp[coin] = 1;
//        }
        Arrays.fill(dp, amount + 1);

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

                }
            }

        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    /**
     * 动态规划
     * <p>
     * 要求 最小的值 可以先 默认赋大值，最后比较是不是大值，若果不是的话说明有结果可以输出；如果是大值说明没有什么变化
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

}
