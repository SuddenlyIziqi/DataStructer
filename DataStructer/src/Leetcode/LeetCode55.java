package Leetcode;

/**
 * 55. 跳跃游戏
 */
public class LeetCode55 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println("nums = " + nums[i]);
        }
        canJump(nums);
    }

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int maxtlenght = 0;
        for (int i = 0; i < length; i++) {
            if (maxtlenght >= i) {
                maxtlenght = Math.max(i + nums[i], maxtlenght);
                if (maxtlenght >= length - 1) {
                    return true;
                }
            }
        }
        return false;


    }

    public static boolean canJump2(int[] nums) {
        int maxtlenght = 0;
        for (int i = 0; i < nums.length; i++) {
            maxtlenght = Math.max(i + nums[i], maxtlenght);
            if (maxtlenght > nums.length) {
                return true;
            }
        }
        return false;

    }


}
