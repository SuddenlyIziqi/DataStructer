package Leetcode;

/**
 *98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class LeetCode98 {
    public static void main(String[] args) {
    }

    /**
     * 此方法是错误的，此方法只能证明左节点<root<右节点
     * 但是不能证明，左节点的子节点<root  比如 root = 3；left =2，left.right =4;这种情况也算通过了，因此此方法不行
     * @param root
     * @return
     */
    public boolean dps(TreeNode root){
        if(root == null) {return true;}

        if(root.left!=null){
            return root.val>root.left.val;
        }
        if(root.right!=null){
            return root.val<root.right.val;
        }
        return dps(root.left)&&dps(root.right);
    }

    /**
     * 此方法标记了每个节点的上下 限，避免了上上述方法的弊端,动态的上下限
     * root.val 必须满足  min<root.val<max
     * @param root
     * @return
     */
    public boolean dps2(TreeNode root,long min,long max){
        if(root == null) {
            return true;
        }

        if(root.val>=max||root.val<=min){
            return false;
        }
        return dps2(root.left,min, root.val)&&dps2(root.right,root.val,max);
    }

    public  boolean isValidBST(TreeNode root) {
//        return dps(root);
        return dps2(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }


    private class TreeNode {
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
