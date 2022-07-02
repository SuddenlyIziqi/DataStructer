package Test;

import javax.annotation.Resource;

public interface MyInterface {
    @Resource()
    public static final int i=1;
    public static int j=1;
     static int k=1;

       void eat();
    public static void drink(String s){
        System.out.println("s = " + s);
    }


    public static void main(String[] args) {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void eat() {

            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        myInterface.eat();
        MyInterface.drink("ss");
    }
}
