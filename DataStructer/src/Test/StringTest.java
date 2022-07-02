package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        String s =new String("asa");
        System.out.println("s.equals(\"asa\") = " + s.equals("asa"));

        ArrayList list =new ArrayList();
        System.out.println("list.equals(new ArrayList()) = " + list.equals(new ArrayList()));
        HashMap hashMap = new HashMap<String, String>();
        System.out.println("hashMap.equals(new HashMap()) = " + hashMap.equals(new HashMap()));
    }
}
