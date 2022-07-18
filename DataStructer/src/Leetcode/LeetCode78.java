package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});

    }
    public static List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        dfs(nums,0);
        return result;
    }

    public static void dfs(int[] nums,int index){
        if(index>= nums.length) return;
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            dfs(nums,index+1);
            path.remove(path.size()-1);
        }

    }


}
