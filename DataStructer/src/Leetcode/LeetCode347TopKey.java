package Leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeetCode347TopKey {
    public static void main(String[] args) {

    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.get(num)==null?1:map.get(num)+1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            if(priorityQueue.size()<k){
                priorityQueue.add(new int[]{key,count});
            }else {
                if(count>priorityQueue.peek()[1]){
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key,count});
                }
            }
        }

        int[] result=new int[k];
        for (int i=0;i<k;i++) {
            result[i]=priorityQueue.poll()[0];
        }
        return result;

    }
}
