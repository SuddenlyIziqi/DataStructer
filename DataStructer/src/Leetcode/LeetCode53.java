package Leetcode;

/**
 * 53. 最大子数组和
 */
public class LeetCode53 {
    public static void main(String[] args) {

    }

    //感觉这行挺核心的：
//pre = Math.max(pre + x, x);
//如果前边累加后还不如自己本身大，那就把前边的都扔掉，从此自己本身重新开始累加。
    //已 i 为最后一位的数组的最大值为   dp[i] = Math.max(nums[i],dp[i-1]+ nums[i])
    public int maxSubArray(int[] nums) {
        int max = 0;
        int pre = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
