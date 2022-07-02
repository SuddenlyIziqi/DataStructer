package Leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 *
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        nextGreaterElement(nums1,nums2);

    }

    /**
     * 分两步走
     * 第一步：处理num2就是单调栈问题，用Map存储结果
     * 第二部：遍历num1，从Map中取得对应的值即可
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] ans = new int[length1];

        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i<length2;i++){
            while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                int tem = stack.pop();
                map.put(nums2[tem],nums2[i]);
            }
            stack.push(i);
        }

        for(int i = 0;i<length1;i++){
            ans[i] = map.get(nums1[i])==null? -1:map.get(nums1[i]);
        }
        return ans;
    }

}
