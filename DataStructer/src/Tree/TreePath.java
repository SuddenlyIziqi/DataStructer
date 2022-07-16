package Tree;

import java.util.ArrayList;
import java.util.List;

public class TreePath {
    List<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {

        TreePath path = new TreePath();
        path.test();

    }


    private void test() {
//        TreeNode root = new TreeNode(1 );
//        TreeNode node2 = new TreeNode(2 );
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();


        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        dfs(node3, node5, pList);
        dfs(node3, node1, qList);
        com(pList, qList);
        for (TreeNode treeNode : list) {
            System.out.println("treeNode.val = " + treeNode.val);
        }
    }

    //记录root到指定节点的路径
    private boolean dfs(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) return false;
        list.add(root);
        if (root.val == target.val) {
            return true;
        }
        if (dfs(root.left, target, list)) {
            return true;
        }
        if (dfs(root.right, target, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    public TreeNode com(List<TreeNode> list1, List<TreeNode> list2) {
        TreeNode commonNode = null;
        for (int i = 0; i < list1.size(); i++) {
            if (i < list2.size()) {
                if (list1.get(i).val == list2.get(i).val) {
                    commonNode = list1.get(i);

                }
                ;
            }
        }

        return commonNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        //
        TreeNode(int x) {
            val = x;
        }
    }
}