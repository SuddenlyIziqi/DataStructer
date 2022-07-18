package Leetcode;

import java.util.ArrayList;

/**34. 在排序数组中查找元素的第一个和最后一个位置
 *
 */

public class LeetCode34 {
    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println("ints = " + ints);

    }
    public static int[] searchRange(int[] nums, int target) {
        if(target<nums[0]||target>nums[nums.length-1]) return new int[]{-1,-1};
        int i = binarySearch(nums, target);
        if(i==-1) return  new int[]{-1,-1};
        int startIndex = i;
        int endIndex = i;
        for (int j = i-1; j >=0; j--) {
            if(nums[j]==target) {
                startIndex = j;
            }else {
                break;
            }
        }
        for (int j = i+1; j <nums.length; j++) {
            if(nums[j]==target) {
                endIndex = j;
            }else {
                break;
            }
        }
        return new int[]{startIndex,endIndex};
    }

    public static int binarySearch(int[] nums,int target){
        String a ="";
        ArrayList arrayList =new ArrayList<>();
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid =left+ (right-left)/2;

            if(nums[mid] == target) return mid;
            if(nums[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
