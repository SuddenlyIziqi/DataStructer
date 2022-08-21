package Leetcode;

import java.util.HashMap;

/**
 * 1. 两数之和
 */
public class LeetCode1 {
    public static void main(String[] args) {
        LeetCode1 leet = new LeetCode1();
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            } else {
                hashMap.put(target - nums[i], i);
            }
        }
        return null;
    }
}
