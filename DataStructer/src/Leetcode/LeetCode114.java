package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 114. 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 */

public class LeetCode114 {
    public void flatten(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return ;
        List<TreeNode> list = new ArrayList<>();
        preOrder(root,list);
        TreeNode temp = root;
        for(int i= 0;i<list.size();i++){
            temp.right = list.get(i);
            temp.left = null;
            temp = temp.right;
        }

    }
    /**
     root 为链表头
     temp 为指针 他的子节点作为被移动的对象
     */
    public void preOrder(TreeNode root, List<TreeNode> list){
        if(root!=null) {
            list.add(root);
            preOrder(root.left,list);
            preOrder(root.right,list);
        }
    }
     private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
