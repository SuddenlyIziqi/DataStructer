package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3.无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap();
        for (int end = 0; end < s.length() ; end++) {
            Character a = s.charAt(end);
            if(map.containsKey(a)&&(map.get(a)>start)){
                Integer integer = map.get(a);
                max = Math.max(end-start,max);
                start=integer+1;
            }else {
                max = Math.max(end-start+1,max);
            }


            map.put(a,end);
        }
        return max;
    }
}
