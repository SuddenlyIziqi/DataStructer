package Leetcode;

/**
 *
 */
public class LeetCode104 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return dps(root, 1);
    }

    public int dps(TreeNode root, int deep) {
        if (root == null) return deep;
        int dps1 = dps(root.left, deep + 1);
        int dps2 = dps(root.right, deep + 1);
        return Math.max(dps1, dps2);
    }

}
