package Stack.TestStack;

import java.util.*;

/**
 *  中缀表达式 转 后缀表达式
 *  1.初始化两个栈（或者一个栈一个队列）：第一个栈@s1存储第一次扫描的运算符，第二个栈（队列）用来存储 数据和中间结果
 *  2.从左到右扫描 中缀表达式 并判断 3,4,5 分支
 *  3.遇到 操作数： 直接压入（入队）第二个栈（队列）
 *  4.遇到 运算符：
 *              4.1 若当前 @s1 为空，或者栈顶为 “(” :则直接压入@s1
 *              4.2 若当前运算符优先级 大于 @s1 栈顶 :则直接压入 s1
 *              4.3 否则 将@s1栈顶运算符弹出并压入 队列:则从4.1 用此运算符 判断
 *  5.遇到 括号：
 *              5.1 若是“(” :则直接压入 @s1
 *              5.2 若是“)”: 则将 @s1栈顶出栈 并压入 队列，直到遇见“(” 为之，将两个括号丢弃即可
 *  6.重复2-5，直到表达式的最右边
 *  7.表达式遍历结束后：将@s1剩余运算符压入 队列中
 *  8.队列出队即为所需要的后缀表达式，如果用的也是栈 则将栈全部出栈后 逆序打印 就是所需的后缀表达式
 *
 *  其中
 *  4 和 5 可以改成下面的
 *   4.遇到 运算符 和 “(”：【优先级 :@s1 为空==null 返回 -1 小于“(” 小于 “+”,“-” 小于 “*”，“/”】
 *              4.1 若当前 @s1 为空，或者栈顶为 “(” :则直接压入@s1
 *              4.2 若当前运算符优先级 大于 @s1 栈顶 :则直接压入 s1
 *              4.3 否则 将@s1栈顶运算符弹出并压入 队列:则从4.1 用此运算符 判断
 *   5.遇到 “)”：则将 @s1栈顶出栈 并压入 队列，直到遇见“(” 为之，将两个括号丢弃即可
 *
 */
public class ToSuffixExpression {
    public static void main(String[] args) {
//        String s = "(3+4)*5-6";
        String s = "1 + ( ( 2 + 3 ) * 4 ) - 5";
        //将String转为 list 便于计算
        List<String> strings = infixExpressionToList(s);
        System.out.println("strings = " + strings);
        //中缀表达式转后缀表达式
        ArrayDeque<String> arrayDeque = infixExpressionToSuffixExpression(strings);
        //后缀表达式用(逆波兰计算器)计算
        int cal = PolandNotation.cal(queueToList(arrayDeque));
        System.out.println("cal = " + cal);
    }

    /**
     * 将中缀表达式(list) 解析成 后缀表达式 (list)
     * @param expressionList
     * @return
     */
    public static ArrayDeque<String> infixExpressionToSuffixExpression(List<String> expressionList){
        Stack<String> stack = new Stack();
        ArrayDeque<String> arrayDeque = new ArrayDeque();
        for (String s : expressionList) {
            //判断当前是否是数字
            if (isNum(s)) {
                //如果是数字
                arrayDeque.add(s);
            }else {
                //不是数字
                //判断是否是“)”
                boolean flag=true;
                while (flag){
                    if (!")".equals(s)) {
                        if (stack.isEmpty()||"(".equals(stack.peek())||"(".equals(s) ) {
                            //4.1 若当前 @s1 为空，或者栈顶为 “(” ,或当前符号是“(”:则直接压入@s1
                            stack.push(s);
                            flag=false;
                        } else if (order(s) > order(stack.peek())) {
                            //4.2 当前运算符优先级大于栈顶（栈顶为空时时 -1;“(” =0;“+”,“-”=1;“*”，“/” =2） 运算符直接入栈
                            stack.push(s);
                            flag=false;
                        } else {
                            //4.3 否则 将@s1栈顶运算符弹出并压入 队列:则从4.1 用此运算符 判断
                            arrayDeque.add(stack.pop());
                            flag=true;
                        }
                    }else {
                        //遇到 “)” 则将 @s1栈顶出栈 并压入 队列，直到遇见“(” 为之，将两个括号丢弃即可
                        while (true){
                            if ("(".equals(stack.peek())){
                                stack.pop();
                                break;
                            }
                            arrayDeque.add(stack.pop());
                        }
                        flag=false;
                    }
                }

            }
        }
        //表达式遍历结束后：将@s1剩余运算符压入 队列中
        while (!stack.isEmpty()){
            arrayDeque.add(stack.pop());
        }
        System.out.println("arrayDeque = " + arrayDeque);
        return  arrayDeque;
    }

    /**
     * 判断当前元素是否是数字
     * @param s
     * @return
     */
    public static boolean isNum(String s){
        return s.matches("\\d+");
    }

    /**
     * 判断运算优先级
     * 数字越大 优先级越高
     * 【优先级 :@s1 为空==null 返回 -1 小于 “(” 小于 “+”,“-” 小于 “*”，“/”】
     * @param s
     * @return
     */
    public static int order(String s){
        switch (s){
            case "(":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

    /**
     * 将中缀字表达式转换成 List
     * 便于后续计算
     * 关键是多位数的拼接
     * @param expression
     * @return
     */
    public static List<String> infixExpressionToList(String expression){
        //用存储返回值
        ArrayList arrayList = new ArrayList();
        //初始化 指针  用来遍历字符串
        int i = 0;
        //初始化 多位数存储 用来存储多位数
        String strings = "";
        //初始化 单字符 用来存储每一个 i 遍历到的 字符
        char ch ;
        do {
            //判断是否为
            if(" ".equals(expression.charAt(i)+"")){
                //空格自动移位
                i++;
            }else {
                //不是空格判断是否是数字
                if(!isNum(ch=expression.charAt(i))){
                    //非数字 直接加入list 并移位
                    arrayList.add(ch+"");
                    i++;
                }else {
                    //字符是数字 判断是否是多位数
                    //将 strings 初始化 用来存储记下来连续的 单数字
                    strings = "";
                    while (i<expression.length()&&isNum(ch=expression.charAt(i))){
                        //拼接单数字 为多位数
                        strings+=ch;
                        i++;
                    }
                    //当前下一个不再是数字的时候 拼接多位数结束 加入list  因为在while中已经i++了这里不再需要i++了
                    arrayList.add(strings);
                }
            }

        }while (i<expression.length());
        return arrayList;
    }

    public static boolean isNum(char ch ){
        return ch>=48&&ch<=57;
    }
    public static List<String> queueToList(ArrayDeque<String> arrayDeque){
        List<String> list =new  ArrayList();

        for (String s : arrayDeque) {
            list.add(s);
        }
        return list;
    }

}
