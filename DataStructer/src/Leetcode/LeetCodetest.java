package Leetcode;

/**
 *
 */
public class LeetCodetest {

    /**
     * 回溯法
     *
     * @param nums
     * @param target
     * @return
     */
    int[] nums;
    int sum = 0;

    public static void main(String[] args) {
        int[] a = new int[]{
                73, 74, 75, 71, 69, 72, 76, 73};


    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;

        back(target, 0);
        return sum;

    }

    void back(int target, int i) {
        if (i == nums.length) {
            if (target == 0) {
                sum++;
            }
            return;
        }
        back(target - nums[i], i + 1);
        back(target + nums[i], i + 1);
    }


}
