package Sort;

import utils.RandomUtils;

public class QuickSort {
    public static void main(String[] args) {
        int[] array ={5,9,4,6,3,7,2,0,1,8};
        RandomUtils randomUtils = new RandomUtils();
        quickSort(array,0,array.length-1);
        Integer[] arr = randomUtils.getRandomArray();

        System.out.println("====");
    }

    public static void quickSort(int[] arr,int l,int r){
        if(l>=r) {
            return;
        }
        int x = l;//left
        int y = r;//right
        int z = arr[l];//

        while (x<y){
            while (x<y&&arr[y]>=z) {y--;}
            if(x<y){ arr[x++] =arr[y];}
            while (x<y&&arr[x]<=z) {x++;}
            if(x<y){ arr[y--] =arr[x];}

        }
        arr[x]=z;
        quickSort(arr, l, x-1);
        quickSort(arr, x+1, r);
    }
}
