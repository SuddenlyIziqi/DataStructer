package Stack.TestStack;


/**
 * 综合计算器  (中缀表达式)
 * 栈 实现思路分析：
 * 需要一个索引@index来遍历字符串
 * 需要两个栈来分别存储数字 和 运算符
 *  1.用一个 指针 @index 来遍历字符串并存储在@ch  ：如果是数字 ，则直接放入数字栈 @numberStack；否则进入环节2
 *  2.如果不是数字是运算符，则先判断运算符栈 @operStack 是否为空；如果为空：直接将此运算符压入@operStack
 *                                                         如果不为空：进入 3
 *
 *  3.判断此运算符和@operStack中的运算符的优先级:如果当前@ch的运算符优先级 <= @operStack栈顶运算符的优先级，则进入4
 *                                         当前@ch的运算符优先级 > @operStack栈顶运算符的优先级,则将此@ch压入@operStack;
 *  4.取出数字栈 @numberStack的第一个栈顶 @num1和第二个栈顶 @num2，加上此时的@operStack栈顶运算符进行运算得出结果后 放入数字栈@numberStack中
 *  5.运算字符串便利完以后需要就需要顺序取出数字栈和符号栈来计算，并输出结果
 */
public class Calculator {
    public static void main(String[] args) throws Exception {


        //用来数字栈第一个栈顶
        int num1 =0;
        ///用来数字栈第而个栈顶
        int num2 =0;
        //用来保存查出来的符号栈 栈顶
        int oper =0;
        //用来保存最终运算结果
        int res =0;
        //用来保存扫码字符串的索引
        int index =0;
        //由索引index 扫描到的获取到的字符
        char ch = ' ';
        //数字栈 用来保存数字信息
        Stack1 numberStack = new Stack1(10);
        //符号栈 用来保存运算符号
        Stack1 operStack = new Stack1(10);
        String expression = "30+20*6-2";
        //多位数时用keepNum来保存多位数字符串
        String keepNum = "";
        while (true) {
            //1.以此得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //1.判断ch是什么：如果是数字 ，则直接放入数字栈 @numberStack；否则进入环节2
            if (!operStack.isOper(ch)) {
                //  1.1是数字则直接放入数字栈 @numberStack
                //  因为栈中默认存储 int 而传入的是 ch（char是字符不是int ）会被自动转换成ASCII码的十进制数字
                // 在ASCII码中：字符'0' 对应的十进制数是48，字符'1' 对应的是十进制数是49；因此要减去48得到真正的十进制数字结果
//                int i=ch - 48;
//                numberStack.push(i);
                //当处理多位数的时候，不能扫描一个数就入栈，需要继续扫描 直到不是数字

                keepNum+=ch;
                if(index+1==expression.length()||numberStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                    numberStack.push(Integer.parseInt(keepNum));
                    keepNum="";
                }


            } else {
                //2.确定ch是运算符号，那么确定此时符号栈是否为空
                if (operStack.isEmpty()) {
                    //为空则压入
                    operStack.push(ch);
                } else {
                    //不为空则继续3
                    //3.判断运算符的优先级
                    if (operStack.order(ch) <= operStack.order(operStack.peek())) {
                         /*
                           3.1如果当前@ch的运算符优先级 <= @operStack栈顶运算符的优先级 则表明应当先计算栈中的运算符 那么进入4
                           4.取出(都出栈)数字栈 @numberStack的第一个栈顶 @num1和第二个栈顶 @num2，加上此时的@operStack栈顶运算符进行运算得出结果后
                           然后注意：a。将运算结果放入数字栈@numberStack中；b.将此时@ch的运算符放入符号栈
                          */
                        //取出 数字栈前两位数据 出栈
                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        //取出 运算符的栈顶  出栈
                        oper =operStack.pop();
                        //计算结果
                        res= numberStack.cal(num1, num2, oper);
                        //将运算结果放入数字栈@numberStack中
                        numberStack.push(res);
                        //将此时@ch的运算符放入符号栈
                        operStack.push(ch);
                    } else {
                        //3.2当前@ch的运算符优先级 > @operStack栈顶运算符的优先级,则将此@ch压入@operStack;
                        operStack.push(ch);
                    }

                }

            }
            //继续遍历
            index++;
            if(index>=expression.length()){
                break;
            }


        }
        //当表达式扫描完毕后 就需要顺序取出数字栈和符号栈来计算，并输出结果
        while (true){
            //当符号栈为空的时候说明表达式扫描完了，此时数字栈剩下的唯一数字就是结果
            if (operStack.isEmpty()) {
                break;
            }
            //取出 数字栈前两位数据 出栈
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            //取出且运算符的栈顶  出栈
            oper =operStack.pop();
            //计算结果
            res = numberStack.cal(num1, num2, oper);
            //将运算结果放入数字栈@numberStack中
            numberStack.push(res);

        }
        res=numberStack.pop();
        System.out.println(expression+"="+res);

    }
}



class Stack1 extends ArrayStack {
    public Stack1(int maxSize) {
        super(maxSize);
    }
    /**
     *  判断是否是运算符
     * @param ch     运算符
     */
    public boolean isOper(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/';
    }
    /**
     * 判断运算优先级
     * 数字越大优先级越高
     * @param ch     运算符
     */
    public int order(int ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:   break;
        }
        return 0;
    }

    /**
     * 运算
     * @param num1   数字栈 第一个栈顶
     * @param num2   数字栈 第二个栈顶
     * @param ch     运算符
     * @return      结果放入 数字栈
     */
    public int cal(int num1,int num2,int ch){
        switch (ch){
            case '+': return num1+num2;
            case '-': return num2-num1;
            case '*': return num1*num2;
            case '/': return num2/num1;
            default:   break;
        }
        return 0;
    }

    /**
     * 查看栈顶
     * 但并不取出
     * @return
     */
    public int peek(){
        return super.stack[top];
    }
}

class ArrayStack{
    //初始化一个数组 用来模拟栈存储数据
    public int[] stack;
    //栈顶@top 初始化为-1
    public int top = -1;
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