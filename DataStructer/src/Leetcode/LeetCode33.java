package Leetcode;

/**
 * 33. 搜索旋转排序数组
 */
public class LeetCode33 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        //临界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }


        //二分查找
        //定义左右索引
        int l = 0;int r = length-1;
        while (l<=r){
            int mid = (l+r)/2;

            if(nums[mid]==target){
                return mid;
            }

            //第一次判断：无序数组一分为二，一定会有且只有两种情况（一边有序，一边无序）
            //1.左边有序，右边无序
            //2.右边有序，左边无序
            if(nums[l]<=nums[mid]){
                //1.左边有序，右边无序
                //1.2 比较 mid 和 target与 0 大小，判断是在左边还是右边
                if(nums[l]<=target&&target<=nums[mid]){
                    //target在 左边有序
                    //边界转向 左边
                    r = mid-1;
                }else {
                    //target在 右边无序
                    l = mid+1;
                }
            }else {
                //2.右边有序，左边无序
                //1.2 比较 mid 和 target与 length-1 大小，判断是在左边还是右边
                if(nums[mid]<=target&&target<=nums[r]){
                    //target在 右边有序
                    //边界转向 右边
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }

}
