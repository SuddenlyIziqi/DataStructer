package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode406 {
    public static void main(String[] args) {

    }
    public int[][] reconstructQueue(int[][] people) {
        //第一步，先把h降序， k升序排列 即p[0]↓ p[1]↑
        //为什么h降序，是因为从前往后的话，低的对高的没影响，只要先排好高的，后续再插入低的的话对高的k值无影响
        //为什么h同 k升序，因为k表示前面还有几个>=该人 h的 人，因此，应当按照升序排列
        Arrays.sort(people,(p1,p2)->{
            if(p1[0]!=p2[0]){
                return p2[0] - p1[0];//降序
            }else {
                return p1[1] - p2[1];//升序
            }
        });
        //第二步，对上面结果 放入新的数组，因为按照h降序，故后续插入的元素对前面插入的元素k无影响，可以任意插入而不影响前面已经插入的元素
        //插入要么插中间，要么查数组尾部
        //根据比较位置k和新数组的长度决定是追加到末尾还是插入指定位置即k（people[i][1]，前面有k个元素大于自己，因为索引从0开始，因此直接放置与k处即可）位置
        //显然，如果，result长度大于 遍历元素person[i]{h,k} 的k的时候，如果直接追加到末尾那么k的实际值就会变成result的长度 >k了
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            if(list.size()<=people[i][1]){
                list.add(people[i]);
            }else {
                list.add(people[i][1],people[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}

