package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42.接雨水
 */
public class LeetCode42 {
    public static void main(String[] args) {
        trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }

    /**
     * 方法一 动态规划
     * 三次扫描
     * 第一次：从左往右扫描 遇高则高，不下降  注意初始化条件 leftMax[0] = height[0];
     * 第二次：从右往左扫描 遇高则高，不下降  注意初始化条件 rightMax[length-1] = height[length-1];
     * 第三次：从左往右扫描 三个数组，左右两个数组（为每单位桶的左右边）取最低值-桶本来高度 就是单位桶接雨水的量
     */

    public static int trap(int[] height){
        int length = height.length;
        if(length<=2) return 0;
        int[] leftMax=new int[length];
        leftMax[0] = height[0];

        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }

        int[] rightMax=new int[length];
        rightMax[length-1] = height[length-1];
        for (int i = length-2; i >=0; i--) {
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }

        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans+=Math.min(rightMax[i],leftMax[i])- height[i];
        }

        return  ans;
    }


    /**
     * 单调栈
     */

    public static int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

}
