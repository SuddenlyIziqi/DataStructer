package Sort;

/**
 * 冒泡排序
 * 在于 两个比较 然后交换位置
 */
public class SelectionSort {
    static int[] arr = {2, 1, 5, 4, 12, 31, 12, 312, 1, 3};

    public static void main(String[] args) {

        //  bubbleSort();
        selectionSort();

    }

    static void selectionSort() {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (arr[i] > arr[min]) {
                //固定位 比后续的最小值大则交换两个值
                arr[i] ^= arr[min];
                arr[min] ^= arr[i];
                arr[i] ^= arr[min];
            }
        }
    }


}
