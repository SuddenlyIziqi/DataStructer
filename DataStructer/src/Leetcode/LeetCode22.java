package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        leetCode22.generateParenthesis(3);
    }

    List<String> list = new ArrayList<>();
    int n = 0;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        help("",0,0);
        return list;
    }

    //核心思想，在left和right不超过 n 的时候，left必须大于right
    public void help(String s,int left,int right){
        //递归终止条件
        if(left == n && right == n){
            list.add(s);
            return;
        }

        //剪枝
        if(left > n || left < right){
            return;
        }

        //判断 如果左右相等则 加入左括号,不能加入右括号
        if(left == right){
            help(s + "(", left + 1, right);
        }
        //如果左括号多 则可以加入左括号，也可以加入右括号
        if (left > right) {
            help(s + "(", left + 1, right);
            help(s + ")", left, right + 1);
        }

    }


    //核心思想，在left和right不超过 n 的时候，left必须大于right
    public void help2(String s, int left, int right) {
        //出口
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        //剪枝
        if (left > n || left < right) {
            return;
        }
        //如果左括号 比右括号多，则可以添加左括号，也可以添加右括号
        if (left > right) {
            //添加
            help2(s + "(", left++, right);
            //添加右括号
            help2(s + ")", left, right++);
        }
        //如果左括号 ==右括号，则只能添加左括号
        if (left == right) {
            help2(s + "(", left++, right);
        }
    }


}
