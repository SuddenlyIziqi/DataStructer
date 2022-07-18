package 算法.Kmp;

/**
 * KMP 看门牌算法
 */
public class KmpTest {

    public static void main(String[] args) {
        String haystack = "aaabaaabbbabaa";
        String needle = "babb";
        int i = strStr(haystack, needle);
        System.out.println("i = " + i);
//        int[] next = getNext("ABABAA");
    }


    public static int strStr(String haystack, String needle) {
        if("".equals(needle)) return 0;
        char[] hChar = haystack.toCharArray();
        char[] nChar = needle.toCharArray();
        int[] next = getNext(nChar);

        //i:
        int i = 0,j=0;
        while (i<haystack.length()){
            while (j>=0&&hChar[i]!=nChar[j]){
                j = next[j];
            }
            i++;j++;

            if(j==needle.length()){
                return i-j;
            }
        }
        return -1;

    }


    public static int[] getNext(char[] chars){
        int length = chars.length;
        int [] next = new int[length+1];
        next[0] = -1;
        int i = 1,j = 0;
        while (i<length){
            if(j<0||chars[i] == chars[j]) next[++i] = ++j;
            else j = next[j];
        }
        return next;
    }
}
