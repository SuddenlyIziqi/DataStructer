package Leetcode;

/**
 * 136. 只出现一次的数字
 */
public class LeetCode136 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }

}
