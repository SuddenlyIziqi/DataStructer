package Leetcode;

/**
 *
 */
public class LeetCode75 {
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 0};
        LeetCode75 leetCode75 = new LeetCode75();
        leetCode75.sortColors3(num);
    }

    //使用一个额外空间数组
    public void sortColors(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[l] = 0;
                l++;
            } else if (nums[i] == 2) {
                result[r] = 2;
                r--;

            }
        }
        for (int i = l; i <= r; i++) {
            result[i] = 1;
        }
        nums = result;
    }
    //不使用额外数组

    public void sortColors2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i <= r && nums[i] == 2) {
                nums[i] = nums[r];
                nums[r--] = 2;
            }
            if (nums[i] == 0) {
                nums[i] = nums[l];
                nums[l++] = 0;
            }
        }
    }

    public void sortColors3(int[] nums) {
        int l = 0;
        int m = 0;
        int r = nums.length - 1;
        while (m <= r) {
            while (m <= r && nums[m] == 2) {
                nums[m++] = nums[r];
                nums[r--] = 2;
            }
            while (nums[m] == 0) {
                nums[m++] = nums[l];
                nums[l++] = 0;
            }
            while (m <= r && nums[m] == 1) {
                m++;
            }
        }
    }
}
