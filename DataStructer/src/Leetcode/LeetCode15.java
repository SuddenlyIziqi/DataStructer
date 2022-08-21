package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 难度
 * 中等
 * <p>
 * 4975
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode15 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        int target = -nums[0];
        for (int i = 0; i < length; i++) {
            if (nums[i] >= 0) break;

            int r = length - 1;
            target = -nums[i];
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            for (int l = i + 1; l < length; l++) {
                //对 l去重
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    continue;
                }
                //如果l>r
                while (l < r && nums[l] + nums[r] > target) {
                    r--;
                }
                //如果 l和r重合 则说明 后续l++只会更大，因此此 l的循环退出
                if (l == r) {
                    break;
                }

                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                }
            }
        }
        return res;
    }


}
