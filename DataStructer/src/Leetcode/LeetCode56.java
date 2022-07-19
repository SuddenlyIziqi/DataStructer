package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *56. 合并区间
 */
public class LeetCode56 {
    public static void main(String[] args) {
        merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            int size = merged.size();
            int[] ints = size>=1?merged.get(size - 1):new int[2];
            int lastR = ints[1];
            if(size==0||lastR<l){
                merged.add(new int[]{l,r});
            }else {
                int maxR = Math.max(lastR,r);
                ints[1] = maxR;
            }
        }
        return merged.toArray(new int[merged.size()][merged.get(0).length]);
    }
}
