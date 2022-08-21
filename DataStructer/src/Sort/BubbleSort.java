package Sort;

/**
 * 冒泡排序
 * 在于 两个比较 然后交换位置
 */
public class BubbleSort {
    static int[] arr = {2, 1, 5, 4, 12, 31, 12, 312, 1, 3};

    public static void main(String[] args) {

        //  bubbleSort();
        bubbleSortLess();

    }

    static void bubbleSort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                }
            }
        }
    }

    static void bubbleSortLess() {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                    flag = false;
                }
            }
            if (flag) break;
        }
    }


}
