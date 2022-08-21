package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 3.无重复字符的最长子串
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        char a = ' ';
        System.out.println(a);
        LeetCode3 leetCode3 = new LeetCode3();
        leetCode3.lengthOfLongestSubstring2("abcabcbb");

    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;

        HashMap<Character, Integer> map = new HashMap();
        for (int end = 0; end < s.length() ; end++) {
            Character a = s.charAt(end);
            if (map.containsKey(a) && (map.get(a) >= start)) {
                Integer integer = map.get(a);
                max = Math.max(end - start, max);
                start = integer + 1;
            } else {
                max = Math.max(end - start + 1, max);
            }


            map.put(a, end);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int start = 0;
        int max = 0;
        // key 为字符 value 为出现在s中的索引下标
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.containsKey(chars[i]) && (hashMap.get(chars[i]) >= start)) {
                //hashMap.get(chars[i])>start 随着 start的不断更新 不断的放弃 start之前的元素，这里虽然未移除，也可以忽略掉了
                //如果当前索引 i 已经出现在hashMap中，而且 滑动窗口 随着 start的不断更新 不断的放弃 start之前的元素，这里虽然未移除，也可以忽略掉了额 因为二
                Integer index = hashMap.get(chars[i]);
                max = Math.max(max, i - start);//注意此时 索引下标i 是与start重复的元素 因此长度 为 i-start
                start = index + 1;//新的起点直接取 重复元素的后一位即可，不需要一个一个遍历
            } else {
                //如果遍历到一直没有找到，则不断增加长度直到遍历找到或者结束 i-start+1 与上面不同是因为这时候 第 i位元素也是不重复的需要加上
                max = Math.max(max, i - start + 1);
            }
            hashMap.put(chars[i], i);
        }

        return max;
    }

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int max = 0;

        for (int i = 0; i < chars.length; i++) {
            HashSet<Character> hashSet = new HashSet();
            int len = 0;
            for (int j = i; j < chars.length; j++) {
                if (!hashSet.contains(chars[j])) {
                    len++;
                    hashSet.add(chars[j]);
                } else {
                    break;
                }
            }
            max = Math.max(max, len);
        }

        return max;
    }
}
