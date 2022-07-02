package Tree;

/**
 * 二叉树 查找
 * 1。前序查找   root在前
 * 2。中序查找   root在中
 * 3。后序查找   root在后
 */
public class BinaryTreeSearch {
    public static void main(String[] args) {
        BinaryTree2 binaryTree = new BinaryTree2();
        MyTreeNode2 root = new MyTreeNode2(1, "1号");
        MyTreeNode2 node2 = new MyTreeNode2(2, "2号");
        MyTreeNode2 node3 = new MyTreeNode2(3, "3号");
        MyTreeNode2 node4 = new MyTreeNode2(4, "4号");
        MyTreeNode2 node5 = new MyTreeNode2(5, "5号");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);


        binaryTree.preSearch(2);

        System.out.println(" ===== ");
        binaryTree.infixSearch(3);
        System.out.println(" ===== ");
        binaryTree.suffixSearch(5);
        System.out.println(" ===== ");

    }


}

class BinaryTree2 {
    private MyTreeNode2 root;

    public void setRoot(MyTreeNode2 root) {
        this.root = root;
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
}


class MyTreeNode2 {
    private int no;
    private String nama;
    private MyTreeNode2 left; // 默认为null
    private MyTreeNode2 right;// 默认为null

    public MyTreeNode2(int no, String nama) {
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

    public MyTreeNode2 getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode2 left) {
        this.left = left;
    }

    public MyTreeNode2 getRight() {
        return right;
    }

    public void setRight(MyTreeNode2 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "MyTreeNode2{" +
                "no=" + no +
                ", nama='" + nama + '\'' +
                '}';
    }


    /**
     * 前序遍历
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
     * 中序遍历
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
     * 后序遍历
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
}