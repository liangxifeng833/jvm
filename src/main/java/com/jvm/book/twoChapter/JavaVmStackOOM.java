package com.jvm.book.twoChapter;

/**
 * 虚拟机参数：-Xss2M
 * Xss设置栈内存容量＝2M
 * 创建线程导致内存溢出异常
 * 因为我本地电脑的java版本是11,书中演示版本为java7,所以该例子病没有测试出预期的结果
 */
public class JavaVmStackOOM {
    private void dontStop() {
        int i = 0;
        while (true) {
            System.out.println("===="+(++i));
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
       JavaVmStackOOM oom = new JavaVmStackOOM();
       oom.stackLeakByThread();
    }
}
