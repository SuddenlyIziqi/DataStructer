package Leetcode;

public class LeetCode5 {
    public static void main(String[] args) {
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
    public static String longestPalindrome1(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            int odd = expandAroundCenter(chars, i, i);
            int even = expandAroundCenter(chars, i, i + 1);
            int len = Math.max(odd, even);
            if (len >= maxLen) {
                maxLen = len;
                begin = i - (maxLen - 1) / 2;
                //i-(maxLen-1)/2 解释 即为 最左边界的索引地址 无论是偶还是奇； 奇数的话(maxLen-1)/2 偶数的话向下取奇数 还是这个数
                /*
                 *  i为当前所在 索引， (maxLen-1)/2为当前所在索引到 左右两边的左边界的距离
                 *   比如 maxLen是奇数，也就是 1 2 3 4  ： i = 2 的时候， maxLen = 3，那么 左边界距离为 （3-1）/2 这个 '-1'是因为中心点（index = 2）所在索引
                 *   比如 maxLen是偶数，也就是 1 2 3 4  ： i = 2 的时候， maxLen = 4，那么 左边界距离为 （4-1）/2 这个 1 为中心点所在索引 左边界距离其实就是 此时为奇数的边界距离
                 * */
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    public static int expandAroundCenter(char[] chars,int left,int right){
        while (left>=0&&right<chars.length&&chars[left]==chars[right]) {
            left--;
            right++;
        }
        return right - left - 1;//此处由于最后一组 i和j是不满足条件的 因此需要 r-1+l-1+1
    }


    /**
     * 暴力解法
     */
    public static String longestPalindrome2(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int begin = 0;
        int maxLen = 1;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (j - i + 1 > maxLen && validePalindromic(chars, i, j)) {
                    begin = i;
                    maxLen = j - i + 1;
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
    }
}
