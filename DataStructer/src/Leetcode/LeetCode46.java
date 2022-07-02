package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println("permute = " + permute);
    }
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        boolean[] table = new boolean[nums.length];

        dfs(nums,0,table);
        return result;
    }

    private static void dfs(int[] nums, int index,boolean[] table) {
        if (path.size() == nums.length) {result.add(new ArrayList<>(path)) ;return;}

        for (int i = 0; i < nums.length; i++) {
            if(table[i]==true) continue;
            path.add(nums[i]);
            table[i] = true;
            dfs(nums, i + 1,table);
            table[i] = false;
            path.remove(path.size() - 1);

        }
    }
}
