package Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        ArrayList arrayList=new ArrayList();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                     System.out.println("线程"+ finalI);
                    arrayList.add(finalI);
                }
            });

        }
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("线程x" );
                arrayList.add("线程x");
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("线程y" );
                arrayList.add("线程y");
            }
        });executorService.execute(new Runnable() {
            @Override
            public void run() {

                System.out.println("线程z" );
                arrayList.add("线程z");
            }
        });
        executorService.shutdown();
        while (true){
            if (executorService.isTerminated()){
                System.out.println("线程执行结束" );
                System.out.println("arrayList = " + arrayList);
                break;
            }
            Thread.sleep(100);
        }
    }
}
