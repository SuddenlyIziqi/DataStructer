package Stack.ArrayStack;

/**
 * 栈
 *
 *  应用：
 *  1.子程序调用  :在跳入子程序之前，会将下个指令的地址存到堆栈中，直到子程序完成后再将地址取出，用以回到原来的程序中
 *  2.递归        与子程序类似，只是除了存储下一条指令的地址外，还将参数，区域变量等数据存入栈中
 *  3.表达式转换 如:中缀转后缀  与求值
 *  4.二叉树遍历
 *  5.图的深度优先 DFS
 */
public class ArrayStackDemo {
    public static void main(String[] args) throws Exception {

        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.show();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.show();

    }




}

/**
 * 定义一个类表示栈结构
 */
class ArrayStack{
    //初始化一个数组 用来模拟栈存储数据
    private int[] stack;
    //栈顶@top 初始化为-1
    private int top = -1;
    // 栈的初始化空间  初始化时已经定死了
    private int maxSize;


    //初始化构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }

    /**
     * 满栈
     *  因为 下表从0开始 故top == maxSize-1时 为满栈
     */
    public boolean isFull(){
        return top == maxSize-1;
    }
    /**
     * 空栈
     */
    public boolean isEmpty(){
        return top==-1;
    }
    /**
     * 入栈
     * 先判断是否栈满
     */
    public void push(int i){
        if (isFull()) {
            System.out.println("栈已满！");
            return;
        }
        //入栈
        top++;
        stack[top]=i;
        System.out.println("此次入栈 = " +  stack[top]);
    }
    /**
     * 出栈
     * 先判断是否栈空
     * 出栈要返回值
     */
    public int pop() throws Exception {
        if (isEmpty()) {
            System.out.println("栈为空");
            throw new Exception("NoEmptyForPop");
        }
        //需要一个临时变量来存储需要出栈的对象 用来return
        int value = stack[top];
        top--;
        System.out.println("此次出栈 = " + value);
        return value;

    }
    /**
     * 遍历
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        System.out.println("当前栈为：");
        System.out.println("-----");
        for (int i = stack.length-1; i >= 0; i--) {
            System.out.println("  "+stack[i]);
        }
        System.out.println("-----");

    }




}