package Leetcode;

/**
 * 617. 合并二叉树
 */
public class LeetCode617 {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        help(root1.left, root2.left);
        help(root1.right, root2.right);
        return root1;
    }

    public TreeNode help(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        help(root1.left, root2.left);
        help(root1.right, root2.right);
        return root1;
    }
}
