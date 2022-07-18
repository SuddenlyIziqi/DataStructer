package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 */
public class LeetCode102 {
    HashMap<Integer,List<Integer> > map = new HashMap<>();
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        help(root,0);
        return new ArrayList<>(map.values());
    }
    public void help(TreeNode node,int level){
        if(node==null) return;
        List<Integer> list = map.getOrDefault(level, new ArrayList<>());
        list.add(node.val);
        map.put(level,list);
        help(node.left,level+1);
        help(node.right,level+1);
    }





}

class TreeNode {
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
