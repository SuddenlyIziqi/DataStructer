package Leetcode;

/**
 * 560. 和为 K 的子数组
 */
public class LeetCode560 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
