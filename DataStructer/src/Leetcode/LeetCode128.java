package Leetcode;

import java.util.HashSet;

/**
 * 128. 最长连续序列
 */
public class LeetCode128 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet();
        for (int num : nums) {
            hashSet.add(num);
        }
        int maxLenght = 0;
        for (Integer integer : hashSet) {
            //先找每一个连续子列的最小的数，然后不断找累加数看是否存在，存在则长度+1;
            if (!hashSet.contains(integer - 1)) {
                //找到当前连续子列的最小数开始累加 并判断是否存在
                Integer currNum = integer - 1;
                int currLength = 0;
                while (hashSet.contains(currNum + 1)) {
                    currLength++;
                    currNum++;
                }
                maxLenght = Math.max(maxLenght, currLength);
            }
        }
        return maxLenght;

    }

}
