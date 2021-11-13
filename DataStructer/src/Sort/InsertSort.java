package Sort;

import java.util.Arrays;

/**
 *  插入排序
 *  发现基本类型的  数组
 *  Arrays.asList(arr) 仍然是数组的地址：I@4554617c
 *  因为 arr 已经是数组的地址（I@4554617c）了 那么 Arrays.asList(I@4554617c) 就是只有 一个I@4554617c 的list
 *  还可以得出 Arrays.asList(I@4554617c)。sizi=1 因为只有数组地址I@4554617c 一个元素
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr ={2,1,5,4,12,31,12,312,1,3};
        insertSort(arr);


        System.out.println("arr = " + Arrays.asList(arr));
    }

    public static void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            //定义待插入的值 也就是每次循环比较的对象：需要拿出来插在前面的值  因为是从第二位 也就是数组下标 为 1 的位置开始 所以 是arr[i+1];  i 此时=0；
            int insertValye = arr[i];
            //定义待插入的位置 初始化在 待插入值的前一位 ，用这个值 与 带出入的值比较
            int insertIndex =i-1 ;
            while (insertIndex>=0&&arr[insertIndex]>arr[i]){
                //前一个元素大于 待插入元素时向后移一位
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            //当循环结束的时候 insertIndex==insertIndex-1 是插入位置的前一位 因此要加1
            arr[insertIndex+1]=arr[i];


            for (int i1 : arr) {
                System.out.print(" " + i1);
            }
            System.out.println(  );
        }

    }

}
