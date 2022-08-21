package Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 */
public class LeetCode394 {
    public static void main(String[] args) {


        String s = "3[a2[c]]";
        decodeStringTest(s);
        decodeStringTest(s);
    }

    public static String decodeStringTest(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList();

        for (char c : chars) {
            if (c != ']') {
                stack.push(c);
            } else {
                //当遍历到 c==']'时，stack.peek() 应当是字母，依次出栈倒序组成 字符串
                StringBuffer sbLetters = new StringBuffer();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sbLetters.insert(0, stack.pop());
                }
                //字母出尽，当前[] 内字母输出位 String 以便后续 *数字
                String temString = sbLetters.toString();
                // 如果此时栈不为空那么，下一个元素为'[' 使其出栈
                stack.pop();

                //'[' 出栈  如果此时栈不为空那么，下一个元素为数字
                StringBuffer sbDigit = new StringBuffer();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sbDigit.insert(0, stack.pop());
                }
                //数字出尽，当前[] 内数字输出位 Integer 以便后续 *字母
                int temInt = Integer.valueOf(sbDigit.toString());


                //数字与字母相*然后入栈
                for (int i = 0; i < temInt; i++) {
                    for (char c1 : temString.toCharArray()) {
                        stack.push(c1);
                    }
                }
            }
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();

    }
    //chars:a b c
    //c
    //b
    //a


    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']')
                stack.push(c); // 把所有的字母push进去，除了]

            else {
                //c == ']'

                //step 1: 取出[] 内的字符串

                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek()))
                    sb.insert(0, stack.pop());

                String sub = sb.toString(); //[ ]内的字符串
                stack.pop(); // 去除[


                //step 2: 获取倍数数字

                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                    sb.insert(0, stack.pop());

                int count = Integer.valueOf(sb.toString()); //倍数


                //step 3: 根据倍数把字母再push回去

                while (count > 0) {
                    for (char ch : sub.toCharArray())
                        stack.push(ch);
                    count--;
                }
            }
        }

        //把栈里面所有的字母取出来，完事L('ω')┘三└('ω')｣
        StringBuilder retv = new StringBuilder();
        while (!stack.isEmpty())
            retv.insert(0, stack.pop());

        return retv.toString();
    }
}
