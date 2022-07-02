package Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * 多线程
 */
public class Test {

    HashMap hashMap = new HashMap<String, String>();

    static class  A{
        private int anInt;
        public A(){

        }

        public A(int anInt) {
            this.anInt = anInt;
        }

        @Override
        public int hashCode() {
            return 100;
        }

        @Override
        public String toString() {
            return "\nA{" +
                    "anInt=" + anInt +
                    '}';
        }
    }




        public static void main(String[] args) throws InterruptedException {


            int[] arr = {2,0,1};
//                sortColors(arr);
            int[] ints = sortColors1(arr);
            System.out.println("ints = " + ints);
    }
    public static int[] sortColors1(int[] nums){
        int n = nums.length;
        int l = 0,r=(n-1);
        for (int i=0;i<=r;i++){
            while (i<=r&&nums[i]==2){
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
            }
            if(nums[i]==0){
                nums[i] = nums[l];
                nums[l] = 0;
                l++;
            }
        }
        return nums;
    }

    public static void sortColors(int[] nums) {
        int[] result = new int[nums.length];
        int l = 0, r = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 ) {
                if(l < nums.length){
                    result[l] = 0;
                }
                l++;
            } else if (nums[i] == 2 ) {
                if( r >= 0){
                    result[r] = 2;

                }
                r--;
            }
        }
        while (l < nums.length) {
            if (result[l] == 2) {
                break;
            }
            result[l] = 1;
            l++;
        }
        System.out.println("l = " + l);
    }
}
