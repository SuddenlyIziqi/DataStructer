package Leetcode;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 */
public class LeetCode300 {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}
