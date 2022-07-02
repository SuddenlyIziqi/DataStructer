package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for (int num : nums) {
            temp[num] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) result.add(i);
        }
        return result;
    }


}
