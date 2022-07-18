package Leetcode;

/**
 * 152. 乘积最大子数组
 */
public class LeetCode152 {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        System.arraycopy(nums, 0, dpMax, 0, length);
        System.arraycopy(nums, 0, dpMin, 0, length);
        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
        }

        int ans = dpMax[0];
        for (int i = 1; i < dpMax.length; i++) {
            ans = Math.max(dpMax[i], ans);
        }
        return ans;
    }
}
