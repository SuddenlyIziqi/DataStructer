package Leetcode;

/**
 * 287. 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class LeetCode287 {
    public static void main(String[] args) {

    }

    /**
     * 方法一：字典
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {

        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (temp[num] == 0) {
                temp[num] = 1;
            } else {
                return num;
            }
        }
        return 0;
    }

    /**
     * 快慢指针相当于 环形链表
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {

        int fast = 0;
        int slow = 0;
        //关键
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int temp = 0;
        while (temp != slow) {
            temp = nums[temp];
            slow = nums[slow];
        }

        return nums[temp];
    }

}
