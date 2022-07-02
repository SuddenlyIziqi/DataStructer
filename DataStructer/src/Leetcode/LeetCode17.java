package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode17 {

    public  List<String> letterCombinations(String digits) {
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
