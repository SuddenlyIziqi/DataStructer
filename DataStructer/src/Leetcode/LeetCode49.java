package Leetcode;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 难度
 * 中等
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 有个坑
 * //char数组转换成String类型
 * //用了toString，发现打印出来的是地址值
 * //why？
 * //
 * //这个toString是Object类的方法，数组类没有重写toString方法，Object默认打印地址值chars1.toString()打出的是地址值
 * 即 String key1 = chars1.toString();的key1其实是chars1的地址值 如：key1.toString() = [C@28d93b30，让道hashM中是无法找到相同key的

 */
public class LeetCode49 {
    //题目理解，就是把相同单词组成的字符串放到一起
    //核心 字符串(字母异位词)求一个hashcode作为hash key 字母异位词作为 values
    //相同单词组成的字符串排序一定是一样的，通过他来 作为key
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "cba";
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        String key1 = chars1.toString();
        String key2 = chars2.toString();
        String s11 = new String(chars1);
        String s22 = new String(chars2);
        System.out.println("s11 = " + s11);
        System.out.println("s22 = " + s22);
        System.out.println("s11 hash(s11)= " + hash(s11));
        System.out.println("s22 hash(s22)= " + hash(s22));
        System.out.println("hash(key) = " + hash(key1));
        System.out.println("hash(key) = " + hash(key2));
        System.out.println("key1.toString() = " + key1.toString());
        System.out.println("key2.toString() = " + key2.toString());

        //char数组转换成String类型
        //用了toString，发现打印出来的是地址值
        //why？
        //
        //这个toString是Object类的方法，数组类没有重写toString方法，Object默认打印地址值

    }

    static  int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            //String key = chars.toString(); //此处有坑，如果通过 chars.toString()方法的得到的key是数组的地址
            //key.toString() = [C@28d93b30 放入HashMap中是一定不相同的会出错
            String key = new String(chars);

            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }

}
