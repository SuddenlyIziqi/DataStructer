package Sort;

/**
 * 快速排序法
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,3,5,1,0};
        sort(arr,0,arr.length-1);
        System.out.println("arr = " + arr);
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

            //3.从数组左边开始，一个一个遍历比较基准值，如果小于基准值，座指针右移
            while (lp<rp && arr[lp] <=benchmark ){
                lp++;
            }
            //4.左指针对应数组元素小于基准值，来到这里，该指针元素放到右指针的位置，然后右指针左移一位
            if(lp<rp) arr[rp--] = arr[lp];
        }
        //此轮比较结束后 也就是左右指针重合了；此时，将基准值放入此位置
        arr[lp] = benchmark;//同 arr[rp] = benchmark
        //递归调用左右两部分进行排序
        sort(arr,l,lp-1);//同 sort(arr,l,rp-1)
        sort(arr,lp+1,r);//同 sort(arr,rp+1,r)
    }
}
