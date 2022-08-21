
package Leetcode;

/**
 * 101. 对称二叉树
 */
public class LeetCode101 {
    public static void main(String[] args) {

    }

    //curr[i] = dp[i-1]*dp[n-i];
    //dp[i] = dp[i-1]+dp[i-1]*dp[n-i];
    //给定一个有序序列
    //1⋯n，为了构建出一棵二叉搜索树，我们可以遍历每个数字
    //i，将该数字作为树根，将
    //1⋯(i−1) 序列作为左子树，
    //(i+1)⋯n 序列作为右子树。接着我们可以按照同样的方式递归构建左子树和右子树。

    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }

    boolean help(TreeNode t1, TreeNode t2) {

        if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) {
            return false;
        }
        if (t1 == null && t2 == null) {
            return true;
        }

        return (t1.val == t2.val) && help(t1.left, t2.right) && help(t1.right, t2.left);
    }

}
