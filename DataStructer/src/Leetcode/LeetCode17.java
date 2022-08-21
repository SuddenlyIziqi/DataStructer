package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode17 {
    HashMap<Character, String[]> map;
    char[] digit;
    List<String> list;

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        List<String> strings = leetCode17.letterCombinations2("23");
        System.out.println("strings = " + strings);
    }

    public List<String> letterCombinations2(String digits) {
        //存储为数组更好操作
        map = new HashMap<Character, String[]>() {{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};
        digit = digits.toCharArray();
        list = new ArrayList<>();
        help(0, new StringBuilder());
        return list;
    }

    private void help(int index, StringBuilder sb) {
        //先超出回溯的出口
        if (index == digit.length) {
            list.add(sb.toString());
            return;
        }
        String[] strings = map.get(digit[index]);
        for (String string : strings) {
            sb.append(string);
            help(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }


    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        HashMap<Character, String[]> map = new HashMap<Character, String[]>() {{    //存储为数组更好操作
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};
        char [] digit =digits.toCharArray();
        back(digit,0,new StringBuffer(),map,result);
        return result;
    }
    public  void back(char [] chars,int index,StringBuffer sb,HashMap<Character, String[]> map,List<String> result){
        if(index == chars.length){
            result.add(sb.toString());
            return;
        }

        String[] strings = map.get(chars[index]);
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            back(chars,index+1,sb,map,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
