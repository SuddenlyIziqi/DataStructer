package Leetcode;

/**
 * 33. 搜索旋转排序数组
 */
public class LeetCode33 {
    public static void main(String[] args) {

    }

//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//
//        int length = nums.length;
//        if (length == 1) {
//            return nums[0] == target ? 0 : -1;
//        }
//
//        int res = -1;
//
//        return res;
//    }


    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                //说明左边是升序，右边是错序
                //看看 target是否在左升序
                if (nums[l] <= target && target <= nums[mid]) {
                    //在左升序 则 查找
                    r = mid - 1;
                } else {
                    //不在左升序，则在右错序
                    l = mid + 1;
                }
            } else {
                //说明左边是错序，右边是升序
                //看看 target是否在右升序
                if (nums[mid] <= target && target <= nums[r]) {
                    //在右序列 则把 l指向mid右边
                    l = mid + 1;
                } else {
                    //不在右序列 则把 r指向mid左边
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            binarySearch(nums, mid + 1, end, target);
        } else {
            binarySearch(nums, mid, end - 1, target);
        }
        return -1;
    }

}
