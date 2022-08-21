package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode39 {
    public static void main(String[]
                                    args) {
        int[] ints = new int[]{2, 7, 6, 3, 5, 1};
        Arrays.sort(ints);
        combinationSum(ints,9);
    }
    static List<List<Integer>>  result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates,target,0);
        return result;
    }
    public static void dfs(int[] candidates,int target,int index){
        if(target==0){
            result.add(new ArrayList<>(path));
        }
        if (candidates[index]>target){
            return;
        }

        for(int i=index;i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],i);
            path.remove(path.size()-1);
        }
    }


}
