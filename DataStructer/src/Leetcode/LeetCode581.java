package Leetcode;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 */
public class LeetCode581 {
    public static void main(String[] args) {

    }

    /**
     * Method:1 double pointers and sort
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        while (l <= r && newNums[l] == nums[l]) {
            l++;
        }
        while (l <= r && newNums[r] == nums[r]) {
            r--;
        }
        return r - l + 1;
    }

    /**
     * Method:2  double pointers and linked scanning
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        int length = nums.length;
        int r = 0;
        int l = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            //from left ro right for r
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }
            //from right ro left
            if (nums[length - 1 - i] > min) {
                l = length - 1 - i;
            } else {
                min = nums[length - 1 - i];
            }
        }
        return l == -1 ? 0 : r - l + 1;
    }


}
