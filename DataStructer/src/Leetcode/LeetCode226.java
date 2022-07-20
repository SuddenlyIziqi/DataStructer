package Leetcode;

public class LeetCode226 {
    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 7, 1, 3, 6, 9};
        TreeNodeDemo treeNodeDemo = creatTree(new TreeNodeDemo(0, a[0]), 0, a);
        invertTree(treeNodeDemo);
    }

    private static TreeNodeDemo creatTree(TreeNodeDemo treeNodeDemo, int i, int[] a) {
        if (i * 2 + 1 >= a.length) {
            return null;
        }
        treeNodeDemo.left=new TreeNodeDemo(i*2+1,a[i*2+1]);
        treeNodeDemo.right=new TreeNodeDemo(i*2+2,a[i*2+2]);
        creatTree(treeNodeDemo.left,i*2+1,a);
        creatTree(treeNodeDemo.right,i*2+2,a);
        return treeNodeDemo;
    }


    public static TreeNodeDemo invertTree(TreeNodeDemo root) {
        invert(root);
        return root;
    }
    public static TreeNodeDemo invert(TreeNodeDemo root){
        TreeNodeDemo temp = new TreeNodeDemo();
        temp=root.left;
        root.left = root.right;
        root.right=temp;
        if(root.left!=null){
            invert(root.left);
        }
        if(root.right!=null){
            invert(root.right);
        }

        return root;
    }
}
 class TreeNodeDemo {
     int index;

     int val;

    TreeNodeDemo left;
    TreeNodeDemo right;

     public TreeNodeDemo(int index,int val ) {
         this.val = val;
         this.index = index;
     }

     TreeNodeDemo() {}
    TreeNodeDemo(int val) { this.val = val; }
    TreeNodeDemo(int val, TreeNodeDemo left, TreeNodeDemo right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


     @Override
     public String toString() {
         return "TreeNodeDemo{" +
                 "index=" + index +
                 ", val=" + val +
                 ", left=" + left +
                 ", right=" + right +
                 '}';
     }
 }