package Stack.TestStack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 * 可用于处理 后缀表达式 suffixExpression
 * 中缀表达式     后缀表达式
 * （3+4）*5-6 => 3 4 + 5 * 6 -
 * 分析
 * 1.将后缀表达式 从左往右遍历，取出第一个3和第二个4放入栈中作为 此时 第二个4为栈顶 第一个3为次顶
 * 2.继续序遍历取出运算符oper 和 出栈 num1 = 4,num2 = 3;res = num2 oper num1 ;得到结果 res 一定要入栈
 *                 //     * 要注意 是次顶 -|/ 栈顶
 *                 //     * 因为先入栈的排在前面是除数/减数，后入栈(栈顶)是被除数/被减数
 * 3.继续遍历 下一个数字入栈
 * 4.继续遍历下一个 运算符 和 出栈 num1 = 4,num2 = 3;res = num2 oper num1 ;得到结果 res 一定要入栈
 * 循环往复 直到结束 取出栈中最后的元素就是所需要的结果
 */
public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "30 4 + 5 * 6 -";
        System.out.println(suffixExpression+" = " + cal(getListString(suffixExpression)));
    }

    /**
     * 将 后缀表达式转换成List 方便操作
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        String[] s = suffixExpression.split(" ");
        return Arrays.asList(s);
    }

    public static int cal(List<String> list) {

        // stack用来存储数据
        Stack<String> stack = new Stack();
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        for (String s : list) {
            // 判断当前元素是否是数字
            if (s.matches("\\d+")) {
                // 如果是数字直接入栈
                stack.push(s);
            } else {
                // 如果是运算符 栈顶和次顶出栈
                // 栈顶出栈
                num1 = Integer.parseInt(stack.pop());
                // 次顶出栈
                num2 = Integer.parseInt(stack.pop());
                // 运算 次顶 opera 栈顶
                //     * 要注意 是次顶 -|/ 栈顶
                //     * 因为先入栈的排在前面是除数/减数，后入栈(栈顶)是被除数/被减数
                res = operation(num1,num2,s);
                //不要忘记 把计算的结果入栈
                stack.push(String.valueOf(res));
            }
        }
        //最后的栈中唯一元素就是所需结果
        return Integer.parseInt(stack.pop());
    }

    /**
     * 计算
     * 要注意 是次顶 -|/ 栈顶
     * 因为先入栈的排在前面是除数/减数，后入栈(栈顶)是被除数/被减数
     * @param num1  栈顶
     * @param num2  次顶
     * @param oper
     * @return
     */
    public static int operation(int num1,int num2,String oper){
        switch (oper){
            case "+":return num1+num2;
            case "-":return num2-num1;
            case "*":return num1*num2;
            case "/":return num2/num1;
        }
        return 0;
    }
}
