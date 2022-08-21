package Leetcode;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class LeetCode215 {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        //优先队列实现小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else {
                if (queue.peek() < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.peek();
    }
}
