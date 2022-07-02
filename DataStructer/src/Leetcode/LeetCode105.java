package Leetcode;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return   buildTreeHelper(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public TreeNode  buildTreeHelper(int[] preorder,int pStrat,int pEnd ,int[] inorder,int iStrat,int iEnd){
        if(pStrat==pEnd){
            return null;
        }
        int rootValue = preorder[pStrat];
        TreeNode root = new TreeNode(rootValue);
        int inordeRootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==rootValue) {
                inordeRootIndex =i;
                break;
            }
        }

        root.left = buildTreeHelper(preorder,pStrat+1,pStrat+1 +(inordeRootIndex - iStrat),inorder,iStrat,inordeRootIndex);
        root.right = buildTreeHelper(preorder,pStrat+1+(inordeRootIndex - iStrat),pEnd,inorder,inordeRootIndex+1,iEnd);


        return root;
    }



      public class TreeNode {
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
