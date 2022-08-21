package Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
//        now.setTime(new Date());
        now.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println("now = " + now);
        Date date = now.getTime();
        System.out.println("date = " + new SimpleDateFormat("yyyyMMdd").format(date));

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("dev");
        ThreadLocal threadLocal2 = new ThreadLocal();
        threadLocal2.set("abc");
        Object o = threadLocal.get();
        Object o2 = threadLocal2.get();
        System.out.println("o = " + o);
        System.out.println("o2 = " + o2);
    }

}
