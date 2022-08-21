package Leetcode;

/**
 *
 */
public class LeetCode236 {
    /**
     * 方法2 递归树
     * 这就是一个后序遍历的模型，只不过是每个父节点都会接收子节点的状态（是否含有p、q）并把这个状态往上传递，直到该结点满足祖先节点的条件。这样一想就豁然开朗了。
     */

    TreeNode result;
    /**
     * 方法1  hashMap
     */
   /* Map<Integer, TreeNode> valueAndParent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        TreeNode tp  = p;
        TreeNode tq  = q;
        while (tp!=null){
            visited.add(tp.val);
            //往上找父亲节点
            tp = valueAndParent.get(tp.val);
        }
        while (tq!=null){
            if(visited.contains(tq.val)){
                return tq;
                // 如果未遍历到则往上找父亲节点
            }
            tq = valueAndParent.get(tq.val);

        }
        return null;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            valueAndParent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            valueAndParent.put(root.right.val,root);
            dfs(root.right);
        }
    }*/
    TreeNode p;
    TreeNode q;

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return result;
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return false;
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if ((l && r) || ((root.val == p.val || root.val == q.val) && (l || r))) {
            result = root;
        }

        return l || r || root.val == p.val || root.val == q.val;
    }
}
