package Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class LeetCode207 {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list= new ArrayList<>();
        int[] preCourse = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0];
            int pre = prerequisite[1];
            preCourse[cur]++;
            list.get(pre).add(cur);
        }

        Deque<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if(preCourse[i]==0){
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            Integer pop = queue.pop();
            count++;
            List<Integer> integers = list.get(pop);
            for (Integer integer : integers) {
                preCourse[integer]--;
                if(preCourse[integer]==0){
                    queue.offer(integer);
                }
            }
        }
        return count==numCourses;
    }
}
