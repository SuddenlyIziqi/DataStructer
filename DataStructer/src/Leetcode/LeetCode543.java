package Leetcode;

/**
 * 543. 二叉树的直径
 */
public class LeetCode543 {
    int max = 0;

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        dps(root);
        return max;
    }

    private int dps(TreeNode root) {
        if (root == null) return 0;
        int left = dps(root.left);
        int right = dps(root.right);
//        max =Math.max(left+right+1,max); 这里错了 错认为长度是左子树长度加柚子树长度+root了 ，求得不是节点，求得是距离 直接就是 left+right
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;//返回的是root到左右 子树的最大高度
    }
//          1
//         / \
//        2   3
//       / \
//      4   5

    //注意这里
}
