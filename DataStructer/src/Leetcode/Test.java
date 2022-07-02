package Leetcode;

public class Test {
    public static void main(String[] args) {
        String s = longestWord(new String[]{""});
        System.out.println("s = " + s);
    }
    public static String longestWord (String[] words) {
        // write code here
        if(words.length<=0) return "";
        int max = 0;
        String s = "";
        for (String word : words) {
            if(word.length()>max){
                s=word;
                max=word.length();
            }
        }
        return s;

    }
}
