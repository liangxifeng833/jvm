package com.jvm.book.threeChapter;

/**
 * Jconsole监视器线程模块测试
 * 线程死锁等待演示
 */
public class JsonsoleThreadDieLock {
    //线程死锁等待演示
    static class SynAddRunable implements Runnable {
        int a,b;
        public SynAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a+b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<500; i++) {
            System.out.println("++++"+i);
            new Thread(new SynAddRunable(1,2)).start();
            new Thread(new SynAddRunable(2,1)).start();
        }
    }
}
