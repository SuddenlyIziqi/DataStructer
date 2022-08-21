package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
//    static List<List<Integer>> result = new ArrayList<>();
//    static List<Integer> path = new ArrayList<>();

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
//        subsets(new int[]{1,2,3});

    }

    public static void dfs(int[] nums, int index) {
        result.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    void back(int[] nums, int index) {

        if (index >= nums.length) return;
        for (int i = index; i < nums.length; i++) {
            path.add(nums[index]);
            result.add(new ArrayList<>(path));
            back(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


}
