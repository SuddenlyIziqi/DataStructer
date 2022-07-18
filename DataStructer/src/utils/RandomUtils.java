package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public  class RandomUtils {
     public  int size = 20;

     public   Integer[] getRandomArray() {
        ArrayList<Object> arrayList =new ArrayList<>(size);
        Random random = new Random();
        for (Object integer : arrayList) {
            int i = random.nextInt(100);
            boolean add = arrayList.add(i);
        }
        return arrayList.toArray(new Integer[size]);
    }

}
