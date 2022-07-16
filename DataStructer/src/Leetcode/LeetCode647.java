package Leetcode;

/**
 * 647. 回文子串
 */
public class LeetCode647 {
    public static void main(String[] args) {
        LeetCode647 leetCode647 = new LeetCode647();
        String s = "aaa";
        int i = leetCode647.countSubstrings(s);
        System.out.println("i = " + i);
    }

    public int countSubstrings(String s) {
        int count = 0;
        int length = s.length();
        //回文思路， 奇数回文和偶数回文
        //1.奇数回文，回文中心为一个字符
        for (int i = 0; i < length; i++) {
            count++;
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < length) {
                char c1 = s.charAt(j);
                char c2 = s.charAt(k);
                if (c1 == c2) {
                    count++;
                    j--;
                    k++;
                } else {
                    break;
                }
            }
        }
        //2.偶数回文，回文中心为一个字符
        for (int i = 0; i < length - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (c1 == c2) {
                count++;
                int j = i - 1;
                int k = i + 2;
                while (j >= 0 && k < length) {
                    char cj = s.charAt(j);
                    char ck = s.charAt(k);
                    if (cj == ck) {
                        count++;
                        j--;
                        k++;
                    } else {
                        break;
                    }
                }
            }

        }
        return count;
    }

}
