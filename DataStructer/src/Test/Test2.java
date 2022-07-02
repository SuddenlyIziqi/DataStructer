package Test;

import java.util.ArrayList;

public class Test2 {


    public static void main(String[] args) {
        Student s1 = new Student("小李");
        System.out.println("s1.hashCode() = " + s1.hashCode());
        Student s2 = new Student("小张");
        swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
    }

    public static void swap(Student x, Student y) {
        ArrayList arrayList=new ArrayList<>();
        System.out.println("x.hashCode() = " + x.hashCode());
        Student temp = x; //s1
        x = y;  //s2
        y = temp;//s1
        x.setName("xxx");
        System.out.println("x:" + x.getName());//s2 小张
        System.out.println("y:" + y.getName());//s1 小李
    }
}
class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}