package Leetcode;

/**
 * 416. 分割等和子集
 * 问题可转换成  求得总和以后 数组中找到总和一半的子序列是否存在
 */
public class LeetCode416 {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;


        return false;
    }
}
