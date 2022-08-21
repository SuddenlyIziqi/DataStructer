package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LeetCode94 {
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        help(root);
        return list;
    }

    void help(TreeNode root) {
        if (root == null) return;
        help(root.left);
        list.add(root.val);
        help(root.right);
    }
}
