package Tree;

/**
 * 顺序存储二叉树
 * 用数组的方式实现树 的前中后序遍历
 *
 * 1. 顺序存储二叉树通常只考虑**完全二叉树**
 * 2. 第n个元素的 左子节点为  2✖️n +1
 * 3. 第n个元素的 右子节点为  2✖️n +2
 * 4. 第n个元素的父节点为 （n-1）/2
 * 5. n表示二叉树的第几个元素（从开始编号）
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();//1,2,4,5,3,6,7
    }


}
class ArrBinaryTree{
    private  int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    /**
     * 前序遍历
     */

    public void preOrder(){
        if (this.arr==null||this.arr.length<=0){
            return;
        }
        this.preOrder(0);
    }
    public void preOrder(int index){

        //输出当前元素
        System.out.println( arr[index] );
        //左递归
        if((index*2+1)<arr.length) preOrder(index*2+1);
        //右递归
        if((index*2+2)<arr.length) preOrder(index*2+2);

    }

    public void infixOrder(int index){
        //左递归
        if((index*2+1)<arr.length) infixOrder(index*2+1);
        //输出当前元素
        System.out.println( arr[index] );
        //右递归
        if((index*2+2)<arr.length) infixOrder(index*2+2);

    }
}

