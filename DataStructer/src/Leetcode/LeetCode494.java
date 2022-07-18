package Leetcode;

/**
 * 494. 目标和
 */
public class LeetCode494 {
    public int[] nums;
    public int target;
    public int count;

    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        help(0, 0);
        return count;
    }

    public void help(int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            help(index + 1, sum - nums[index]);
            help(index + 1, sum + nums[index]);
        }
    }


}
