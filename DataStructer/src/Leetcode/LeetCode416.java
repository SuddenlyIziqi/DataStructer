package Leetcode;

/**
 * 416. 分割等和子集
 * 转换成 在数组内找元素和为 数组总和的 一半
 */
public class LeetCode416 {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        //1.先获取总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println("sum = " + sum);

        if((sum&1)==1) {
            return false;
        }
        int targetSum = sum/2;
        int length = nums.length;
        boolean[][] dp = new boolean[length][targetSum+1];
        if (nums[0] <= targetSum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                //先把上一行结果赋值下来在修改
                dp[i][j] = dp[i-1][j];

                if(nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }

                if(nums[i] < j){
                    dp[i][j] = dp[i][j]||dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[length-1][targetSum];

    }


    public boolean canPartition1(int[] nums) {
        int len = nums.length;
        // 题目已经说非空数组，可以不做非空判断
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }
}


