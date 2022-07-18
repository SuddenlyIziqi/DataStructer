package Tree;

/**
 * 二叉树
 * 1。前序遍历   root在前
 * 2。中序遍历   root在中
 * 3。后序遍历   root在后
 */
public class BinaryTreeDemo {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        MyTreeNode root = new MyTreeNode(1, "1号");
        MyTreeNode node2 = new MyTreeNode(2, "2号");
        MyTreeNode node3 = new MyTreeNode(3, "3号");
        MyTreeNode node4 = new MyTreeNode(4, "4号");
        MyTreeNode node5 = new MyTreeNode(5, "5号");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);
        binaryTree.delNode(1);
        binaryTree.preOrder();
        System.out.println(" ===== " );
        binaryTree.infixOrder();
        System.out.println(" ===== " );
        binaryTree.suffixOrder();
        System.out.println(" ===== " );

    }



}
class BinaryTree{
    private MyTreeNode root;

    public void setRoot(MyTreeNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(this.root!=null){
            this.root.prefixOrder();
        }else {
            System.out.println(" root = null " ) ;
        }
    }
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println(" root = null " ) ;
        }
    }
    public void suffixOrder(){
        if(this.root!=null){
            this.root.suffixOrder();
        }else {
            System.out.println(" root = null " ) ;
        }
    }

    public void preSearch(int i) {
        if (this.root != null) {
            this.root.prefixSearch(i);
        } else {
            System.out.println(" root = null ");
        }
    }

    public void infixSearch(int i) {
        if (this.root != null) {
            this.root.infixSearch(i);
        } else {
            System.out.println(" root = null ");
        }
    }

    public void suffixSearch(int i) {
        if (this.root != null) {
            this.root.suffixSearch(i);
        } else {
            System.out.println(" root = null ");
        }
    }
    public void delNode(int i ){
        if(root!=null){
            if(root.getNo()==i){
                root = null;
                return;
            }
            this.root.delNode(i);
        }

    }
}


class MyTreeNode{
    private int no;
    private String nama;
    private MyTreeNode left; // 默认为null
    private MyTreeNode right;// 默认为null

    public MyTreeNode(int no, String nama) {
        this.no = no;
        this.nama = nama;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "MyTreeNode{" +
                "no=" + no +
                ", nama='" + nama + '\'' +
                '}';
    }


    /**
     * 前序遍历
     * 1.先输出当前节点（初始节点为 root）
     * 2.如果左子节点不为空，则递归继续前序遍历
     * 3.如果右子节点不为空，则递归继续前序遍历
     */

    public void prefixOrder(){
        System.out.println("root = " +this);
        if(this.getLeft()!=null){
            this.getLeft().prefixOrder();
        }
        if(this.getRight()!=null){
            this.getRight().prefixOrder();
        }
    }
    /**
     * 中序遍历
     * 1.如果左子节点不为空，则递归继续中序遍历
     * 2.输出当前节点（初始节点为 root）
     * 3.如果右子节点不为空，则递归继续中序遍历
     */
    public void infixOrder(){
        if(this.getLeft()!=null){
            this.getLeft().infixOrder();
        }
        System.out.println(this);
        if(this.getRight()!=null){
            this.getRight().infixOrder();
        }
    }
    /**
     * 后序遍历
     * 1.如果左子节点不为空，则递归继续后序遍历
     * 2.如果右子节点不为空，则递归继续后序遍历
     * 3.输出当前节点（初始节点为 root）
     */

    public void suffixOrder(){
        if(this.getLeft()!=null){
            this.getLeft().suffixOrder();
        }
        if(this.getRight()!=null){
            this.getRight().suffixOrder();
        }
        System.out.println(this);

    }

    /**
     * 前序遍历查找
     * 1.先输出当前节点（初始节点为 root）
     * 2.如果左子节点不为空，则递归继续前序遍历
     * 3.如果右子节点不为空，则递归继续前序遍历
     *
     * @param i
     */

    public void prefixSearch(int i) {
        if (this.getNo() == i) {
            System.out.println("root = " + this);
            return;
        }
        if (this.getLeft() != null) {
            this.getLeft().prefixSearch(i);
        }
        if (this.getRight() != null) {
            this.getRight().prefixSearch(i);
        }
    }

    /**
     * 中序遍历查找
     * 1.如果左子节点不为空，则递归继续中序遍历
     * 2.输出当前节点（初始节点为 root）
     * 3.如果右子节点不为空，则递归继续中序遍历
     *
     * @param i
     */
    public void infixSearch(int i) {

        if (this.getLeft() != null) {
            this.getLeft().infixSearch(i);
        }
        if (this.getNo() == i) {
            System.out.println("root = " + this);
            return;
        }
        if (this.getRight() != null) {
            this.getRight().infixSearch(i);
        }
    }

    /**
     * 后序遍历查找
     * 1.如果左子节点不为空，则递归继续后序遍历
     * 2.如果右子节点不为空，则递归继续后序遍历
     * 3.输出当前节点（初始节点为 root）
     *
     * @param i
     */

    public void suffixSearch(int i) {

        if (this.getLeft() != null) {
            this.getLeft().suffixSearch(i);
        }
        if (this.getRight() != null) {
            this.getRight().suffixSearch(i);
        }
        if (this.getNo() == i) {
            System.out.println("root = " + this);
            return;
        }

    }


    /**
     * 删除节点
     * 这里只是简单删除，
     * 1。如果是叶子节点，只需要删除叶子节点
     * 2。如果是非叶子节点，则其子节点也会被删除
     *
     * 注意：就像单项链表一样，如果要删除节点，需要保存上一个节点；对于单项二叉树来说，不能直接删除当前节点，只能取节点的left或者right来删除
     * 所谓删除只需要： his.left=null;或者  this.right=null; 即可
     *
     * 1。先判断root节点是否是 null ，不是则继续
     * 2。判断左子树是否为所求，是的话删除并返回
     * 3。判断右子树是否为所求，是的话删除并返回
     * 4。判断
     */
    public void delNode(int i){
        if(this.left!=null&&this.left.getNo()==i){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.getNo()==i){
            this.right=null;
            return;
        }

        if(this.left!=null){
            this.left.delNode(i);
        }
        if(this.right!=null){
            this.right.delNode(i);
        }
    }
}