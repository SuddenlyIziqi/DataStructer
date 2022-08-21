package Leetcode;

import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class LeetCode20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (char aChar : chars) {
            if(!stack.isEmpty()){
                char peek = (char) stack.peek();
                if((peek=='('&&aChar==')')
                        ||(peek=='['&&aChar==']')
                        ||(peek=='{'&&aChar=='}')
//                        ||(peek==')'&&aChar=='(')
//                        ||(peek==']'&&aChar=='[')
//                        ||(peek=='}'&&aChar=='{')
                ){
                    stack.pop();
                }else {
                    stack.push(aChar);
                }
            } else {
                stack.push(aChar);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;

    }

    public boolean isValid2(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character peek = stack.pop();
                    if (peek == '(' && aChar != ')' || peek == '[' && aChar != ']' || peek == '{' && aChar != '}') {
                        return false;
                    }
                }

            }
        }
        return stack.isEmpty();
    }
}
