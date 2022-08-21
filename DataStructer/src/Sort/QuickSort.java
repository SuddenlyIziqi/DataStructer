package Sort;

import java.util.Arrays;

/**
 * 快速排序法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
    }
    public static void sort(int[] arr,int l,int r){

        //递归退出条件
        if(l>=r) return;
        //定义临时变量，存储:左右指针
        int lp = l,rp = r;
        //定义临时变量，存储:当前基准值
        int benchmark = arr[l];
        while (lp<rp){
            //1.从数组右边开始，一个一个遍历比较基准值，如果大于基准值，右指针左移
            while (lp<rp && arr[rp] >=benchmark ){
                rp--;
            }
            //2.右指针对应数组元素小于基准值，来到这里，该指针元素放到左指针的位置，然后左指针右移一位
            if(lp<rp) arr[lp++] = arr[rp];

            //3.从数组左边开始，一个一个遍历比较基准值，如果小于基准值，左指针右移
            while (lp<rp && arr[lp] <=benchmark ){
                lp++;
            }
            //4.左指针对应数组元素小于基准值，来到这里，该指针元素放到右指针的位置，然后右指针左移一位
            if (lp < rp) arr[rp--] = arr[lp];
        }
        //此轮比较结束后 也就是左右指针重合了；此时，将基准值放入此位置
        arr[lp] = benchmark;//同 arr[rp] = benchmark
        //递归调用左右两部分进行排序
        sort(arr, l, lp - 1);//同 sort(arr,l,rp-1)
        sort(arr, lp + 1, r);//同 sort(arr,rp+1,r)
    }


    public static void quickSort(int[] arr, int l, int r) {
        if (l == r) return;
        //保存基准值 为 当前区间的 l，并取出来 用于后续交换，此时 l的位置就可以直接放入别的值 而不怕原来的基准值好不到了
        int bench = arr[l];
        //因为 l和 r后续 分支还需要使用，因此需要新的指针用来遍历
        int lp = l;
        int rp = r;
        while (lp <= rp) {
            //从右边rp开始遍历，如果 arr[rp] 大于 bench 则 rp左移，直到 arr[rp]<bench 然后  把 arr[rp] 的元素放在 l处
            while (lp <= rp && arr[rp] >= bench) {
                rp--;
            }
            if (lp <= rp && arr[rp] < bench) {
                arr[lp] = arr[rp];
                lp++;
            }
            //直到 arr[rp]<bench 然后  把 arr[rp] 的元素放在 l处；然后lpyou'yu

            while (lp <= rp && arr[lp] <= bench) {
                lp++;
            }
            if (lp <= rp && arr[lp] > bench) {
                arr[rp] = arr[lp];
            }
        }
        //到最后 lp = rp的时候遍历结束了，把基准值放在此处即可 这样子 lp 左边就是左子序列，右边就是柚子序列
        arr[lp] = bench;

        sort(arr, l, lp - 1);
        sort(arr, lp + 1, r);

    }
}
