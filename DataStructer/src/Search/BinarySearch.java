package Search;

/**
 * 二分查找
 */
public class BinarySearch {
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

}
