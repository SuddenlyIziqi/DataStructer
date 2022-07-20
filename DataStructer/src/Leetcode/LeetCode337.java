package Leetcode;


import java.util.HashMap;

public class LeetCode337 {
    HashMap<TreeNode, Integer> hashMap = new HashMap();

    public static void main(String[] args) {

    }

    /**
     * Math.max(当前+隔代，下一代)
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        int money1 = root.val;
//        if (root.left != null) {
//            money1 += (rob(root.left.left) + rob(root.left.right));
//        }
//        if (root.right != null) {
//            money1 += (rob(root.right.left) + rob(root.right.right));
//        }
//
//        int money2 = (rob(root.left) + rob(root.right));
//        return Math.max(money1, money2);
        int[] ints = robInter(root);
        return Math.max(ints[0], ints[1]);
    }

    public int rob1(TreeNode root) {
        if (root == null) return 0;
        Integer integer = hashMap.get(root);
        if (integer != null) return hashMap.get(root);
        int money1 = root.val;
        if (root.left != null) {
            money1 += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            money1 += (rob(root.right.left) + rob(root.right.right));
        }

        int money2 = (rob(root.left) + rob(root.right));
        int money = Math.max(money1, money2);
        hashMap.put(root, money);
        return money;
    }


    /**
     * 我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
     * 任何一个节点能偷到的最大钱的状态可以定义为
     * <p>
     * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     */
    public int[] robInter(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInter(root.left);
        int[] right = robInter(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
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
