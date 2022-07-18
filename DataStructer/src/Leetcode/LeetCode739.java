package Leetcode;

import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode739 {
    public static void main(String[] args) {


    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        //方法一 暴力 N²
        for(int i = 0;i<temperatures.length;i++){
            answer[i]=0;
            for(int j = i+1;j<temperatures.length;j++){
                if(temperatures[j]>temperatures[i]){
                    answer[i]=j-i;
                    break;
                }
            }
        }
        //方法二 单调栈
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<temperatures.length;i++){
            while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int tem = stack.pop();
                answer[tem]=i-tem;
            }
            stack.push(i);
        }
        return answer;

    }

}
