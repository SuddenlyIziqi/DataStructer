package Test;

import java.util.Stack;

public class LeetCode {
    public static void main(String[] args) {
//        long i = uniquePaths(13, 23);
//        System.out.println("i = " + i);
        System.out.println("'1' = " + '1');
        System.out.println("'1' = " + '1');
        int i = '1' + 'a';

        int j0 = '0';
        int j1= '1';
        int j9 = '9';
        System.out.println("j0 = " + j0);
        System.out.println("j1 = " + j1);

        System.out.println("j9 = " + j9);
        LeetCode leetCode = new LeetCode();
        leetCode.decodeString("3[a2[cd]]");


    }
    public static long uniquePaths(int m, int n) {
        long j = 1;
        long k = 1;
        for(int i = 2;i<=m+n-2;i++ ){
            if(i>m-1) {
                j*=i;
//                if(j>k){
//
//                    j = j/k;
//                }
            }
            if(i<=n-1) {k*=i;}
        }
        return (int)(j/k);
    }
    public int findDuplicate(int[] nums) {

        int fast = 0;
        int slow = 0;
        fast = nums[nums[fast]];
        slow = nums[slow];
        while (fast!=slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int temp = 0;
        while (temp!=slow){
            temp = nums[temp];
            slow = nums[slow];
        }
        return temp;
    }
    //j0 = 48
    //j1 = 49
    //j9 = 57
    int type = 1;//[ ]
    //int type = 1;// 0-9
    //int type = 2;//a-z

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        String temp = String.valueOf(chars[0]);
      //  Character.isLetter();//是否是字母
      //  Character.isDigit();//是否是数字
        for (int i = 1; i < chars.length; i++) {
            if(Character.isDigit(chars[i])){
                if(Character.isDigit(temp.charAt(temp.length()-1))){
                    temp+=String.valueOf(chars[i]);
                }else {
                    stack.push(temp);
                    temp=String.valueOf(chars[i]);
                }
            }else if(Character.isLetter(chars[i])){
                if(Character.isLetter(temp.charAt(temp.length()-1))){
                    temp+=String.valueOf(chars[i]);
                }else {
                    stack.push(temp);
                    temp=String.valueOf(chars[i]);
                }
            }else {
                stack.push(temp);
                temp=String.valueOf(chars[i]);
            }
        }
        stack.push(temp);

        Stack stack2 = new Stack();
        while (stack.size()>1){
            Object pop = stack.pop();
            if("]".equals(pop)){

            }else if("[".equals(pop)){

            }
            if("]".equals(pop)){
                while(!"[".equals(stack.peek())){
                    stack.push(pop);
                }
                stack.pop();

                pop = stack.pop();
                stack.pop();
                StringBuilder sb = new StringBuilder();
                Object pop1 = stack.pop();
                Integer integer = Integer.valueOf((String) pop1);
                for (Integer i = 0; i < integer; i++) {
                    sb.append(pop);
                }
                stack2.push(sb);
            }else {
                stack2.push(pop);
            }
        }



        return null;
    }


}
