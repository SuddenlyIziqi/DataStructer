package Leetcode;

/**
 * 31. 下一个排列
 */
public class LeetCode31 {
    public static void main(String[] args) {
        LeetCode31 leetCode31 = new LeetCode31();
//        int i = leetCode31.binarySearch(new int[]{1, 2, 3, 4, 5}, 0, 4, 3);
//        int i = leetCode31.binarySearchDesc(new int[]{5, 4, 3, 2, 1}, 0, 4, 3);
//        System.out.println("i = " + i);
        leetCode31.nextPermutation(new int[]{1, 1});

    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int length = nums.length;
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            //i<0说明 数组为逆序，因此正序后直接输出  此时 i= -1
            //Arrays.sort(nums);
            reverse(nums, 0, length - 1);
        } else {
            //i>=0 说明 存在
            int j = binarySearchDesc(nums, i + 1, length - 1, nums[i]);
            swap(nums, i, j);
            reverse(nums, i + 1, length - 1);
        }
    }

    /**
     * 正序 二分查找
     *
     * @param nums
     * @param l
     * @param r
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * 逆序 二分查找
     *
     * @param nums
     * @param l
     * @param r
     * @param target
     * @return
     */
    public int binarySearchDesc(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    //翻转区间内元素 比如原来逆序，可翻转为正序
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    //交换两个元素
    public void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

}
