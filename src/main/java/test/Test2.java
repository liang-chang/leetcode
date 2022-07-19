package test;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.LockSupport;

public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("do something start");
            System.out.println("子线程thread给自己增加一个许可");
            LockSupport.unpark(Thread.currentThread());

            LockSupport.park();
            System.out.println("park 1");

            LockSupport.park();
            System.out.println("park 2");

            System.out.println("do something end");
        });

        thread.start();
        Thread.sleep(5_000);
        LockSupport.unpark(thread);

    }
}
