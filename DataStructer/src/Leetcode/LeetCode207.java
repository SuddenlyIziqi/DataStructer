package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 */
public class LeetCode207 {
    public static void main(String[] args) {


    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立存放 课程的list   其中 index为前置课程，对应的value 为学了改前置课程之后 可以学的课程
        List<List<Integer>> courseList = new ArrayList<>();
        //初始化
        for (List<Integer> list : courseList) {
            courseList.add(new ArrayList<>());
        }
        //建立 存放前置课程数目的 数组  其中 index为当前课程编号  对应的value 为前置课程
        int[] preCourses = new int[numCourses];

        //把prerequisites导入 上面两个集合
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            preCourses[cur]++;
            courseList.get(pre).add(cur);
        }
        //遍历 前置课程数组，如果当前课程的前置数组 ==0，说明可以学习
        //
        for (int i = 0; i < numCourses; i++) {

        }


        return false;
    }

}
