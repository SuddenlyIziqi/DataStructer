package Leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class LeetCode139 {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String s1 : wordDict) {
            minLen = Math.min(s1.length(),minLen);
            maxLen = Math.max(s1.length(),maxLen);
            wordDictSet.add(s1);
        }
        //考虑到 s.substring(j,i) 左包又不包 遍历的 i从1->s.length() dp 也是 0 ->s.length()-1默认dp[0] = true; 表示空字符
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        //考虑到 s.substring(j,i) 左包又不包 遍历的 i从1->s.length() 那么截取的索引才是从 0 ->s.length()-1
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(i-j <minLen){
                    break;
                }
                if(dp[j]&&wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
