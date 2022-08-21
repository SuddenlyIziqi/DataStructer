package Test;

import java.util.ArrayList;
import java.util.HashMap;

public class StringTest {
    public static void main(String[] args) {
        String s = new String("asa");
        System.out.println("s.equals(\"asa\") = " + s.equals("asa"));

        ArrayList list = new ArrayList();
        ArrayList list2 = list;
        System.out.println("list==list2 = " + (list == list2));
        System.out.println("list.equals(new ArrayList()) = " + list.equals(new ArrayList()));
        HashMap hashMap = new HashMap<String, String>();
        System.out.println("hashMap.equals(new HashMap()) = " + hashMap.equals(new HashMap()));


        String a = new String("abc");
        String b = a;
        b = a;
        System.out.println("a==b = " + a == b);


    }
}
