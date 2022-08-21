package Leetcode;

/**
 *
 */
public class LeetCode11 {
    public static void main() {
        LeetCode11 leet = new LeetCode11();
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int max = 0;
        while (i < j) {

            int area = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(area, max);
            if (height[i] <= height[j]) {
                i++;

            } else {
                j--;
            }
        }

        return max;
    }
}
