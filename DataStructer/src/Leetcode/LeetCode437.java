package Leetcode;

/**
 *
 */
public class LeetCode437 {
    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
    }

    public int pathSum(TreeNode root, int targetSum) {
        //先遍历所有节点，在按照节点进行dps
        if (root == null) {
            return 0;
        }
        int pathSum = rootSum(root, targetSum);
        pathSum += pathSum(root.left, targetSum);
        pathSum += pathSum(root.right, targetSum);
        return pathSum;
    }

    /**
     * 返回
     *
     * @param root
     * @param targetSum
     * @return 返回值是 路径数
     */
    public int rootSum(TreeNode root, long targetSum) {
        int pathSum = 0;
        if (root == null) {
            return 0;
        }
        int rootValue = root.val;
        if (rootValue == targetSum) {
            pathSum++;
        }
        pathSum += rootSum(root.left, targetSum - rootValue);
        pathSum += rootSum(root.right, targetSum - rootValue);
        return pathSum;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
