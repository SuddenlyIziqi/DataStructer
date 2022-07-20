package Leetcode;

/**
 * 33. 搜索旋转排序数组
 */
public class LeetCode33 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int length = nums.length;
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int res = -1;

        return res;
    }

}
