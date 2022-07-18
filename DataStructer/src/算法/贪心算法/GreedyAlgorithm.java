package 算法.贪心算法;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 *
 *
 * 现有 5 个 广播站 刚补的区域为
 * k1:
 * k2:
 * k3:
 * k4:
 * k5:
 *
 *
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        for (String arg : args) {

        }
        String a = "";
        char[] chars = a.toCharArray();
        for (char aChar : chars) {

        }
        HashSet<String> k1 = new HashSet();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");
        HashSet<String> k2 = new HashSet();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");
        HashSet<String> k3 = new HashSet();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        HashSet<String> k4 = new HashSet();
        k4.add("上海");
        k4.add("天津");
        HashSet<String> k5 = new HashSet();
        k5.add("杭州");
        k5.add("大连");



        //放置所以区域
        HashSet<String> allK = new HashSet();
        allK.addAll(k1);
        allK.addAll(k2);
        allK.addAll(k3);
        allK.addAll(k4);
        allK.addAll(k5);
        //放置所有广播站
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();
        hashMap.put("k1",k1);
        hashMap.put("k2",k2);
        hashMap.put("k3",k3);
        hashMap.put("k4",k4);
        hashMap.put("k5",k5);

        String maxKey = "";
        int maxNum = 0;
        HashSet<String> temp = new HashSet();
        HashSet<String> resultKey = new HashSet();

        while (allK.size()>0){
            //1.遍历所有广播站，找到 区域最多的复制给 maxKey；并把区域数赋值给maxNum；
            for (String s : hashMap.keySet()) {
                HashSet<String> strings = hashMap.get(s);
                if (maxNum<=0||maxNum < strings.size()) {
                    maxNum = strings.size();
                    maxKey = s;
                }
            }
            //2.得到当前覆盖所有区域【（allK）减去已经出去的区域后的所有区域】最多的广播站maxKey后，把存在全部区域（allK）中的区域给一处,
            //如果有交集的话，将交集存在临时表 temp 中，用于之后其他广播站也除去这些交集；从而重新获取maxNum和maxKey
            for (String s : hashMap.get(maxKey)) {
                if(allK.remove(s)) temp.add(s);
            }
            /*h
            * temp = temp.
            *
            * */
            resultKey.add(maxKey);
            //3.遍历所有广播站，所有广播站去除temp中的区域；也就是allk中已经不存在temp的区域了，为了达到贪心的目的，需要重新获取maxNum和maxKey
            for (String s : hashMap.keySet()) {
                HashSet<String> strings = hashMap.get(s);
                strings.removeAll(temp);
            }
            //4.temp使用完毕，可以置空等待下一轮了；
            temp.clear();
            maxKey = "";
            maxNum = 0;
        }


        System.out.println("resultKey = " + resultKey);
    }

}
