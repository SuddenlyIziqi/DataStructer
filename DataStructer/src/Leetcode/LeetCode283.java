package Leetcode;

public class LeetCode283 {
    public static void main(String[] args) {

        moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
    }
    public static void moveZeroes(int[] nums) {
        int p1 = 0;
        for(int p2 = 1;p2<nums.length;p2++){

            if(p1<nums.length&&nums[p2]!=0){
                if(nums[p1]==0){
                    nums[p1]^=nums[p2];
                    nums[p2]^=nums[p1];
                    nums[p1]^=nums[p2];
                }
                p1++;
            }else if(p1<nums.length&&nums[p1]!=0) {
                p1++;
            }
        }
        System.out.println("p1 = " + p1);
    }

}
