package Leetcode;

public class LeetCode5 {
    public static void main(String[] args) {
        String cbbd = longestPalindrome("babad");
        System.out.println("cbbd = " + cbbd);
    }

    /**
     * 动态规划
     */
    public static String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        //dp[i][j] = dp[i+1][j-1] && s[i]==s[j]

        //可以知道 要想知道当前位置dp[i][j] 是否 true 需要看左下角dp[i+1][j-1]是否是true&&当前边界  s[i]==s[j]
        //因此可以采用逐列便利的方法
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i < chars.length; i++) {
                if(chars[i]!=chars[j]){
                    dp[i][j] = false;
                }else {
                    //chars[i]==chars[j] 当前边界是相等的
                    if(j-i<3){//j-i+1 -2 <2 ==>j-i<3   j-i+1 为当前数组长度，-2 是减去连个边界 ，<2 也就是剩下只有0个或者1个自然的： dp[i+1][j-1]就是回文子串了，那么
                        //dp[i][j] 也就是回文子串了
                        dp[i][j]=true;
                    }else {
                        //如果剩余数组长度 大于1则，取左下角
                        dp[i][j] = dp[i+1][j-1];
                    }

                }
                //记录数据
                if( dp[i][j]&&j-i+1>maxLen){
                    begin = i;
                    maxLen =j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);

    }


    /**
     * 中心扩散法
     */
   /* public static String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            int odd = expandAroundCenter(chars, i, i);
            int even = expandAroundCenter(chars, i, i+1);
            int len = Math.max(odd,even);
            if(len>=maxLen){
                maxLen = len;
                begin = i-(maxLen-1)/2;
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    public static int expandAroundCenter(char[] chars,int left,int right){
        while (left>=0&&right<chars.length&&chars[left]==chars[right]) {
            left--;
            right++;
        }
        return right-left-1;
    }
*/


    /**
     * 暴力解法
     */
   /*     public static String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if (j - i +1> maxLen && validePalindromic(chars,i,j)){
                    begin = i;
                    maxLen = j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    public static boolean validePalindromic(char[] chars,int left,int right){
        while(left<right){
            if(chars[left]!=chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }*/
}
