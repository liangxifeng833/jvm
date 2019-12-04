package com.jvm.book.twoChapter;

/**
 * 虚拟机参数：-Xss128k
 * Xss设置栈内存容量＝128k
 * 虚拟机和本地方法栈OOM测试
 */
public class JavaVmStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    /**
     * 以下程序会抛出异常：
     * Exception in thread "main" java.lang.StackOverflowError
     * 线程请求的栈深度大于虚拟机所允许的最大深度
     * @param args
     */
    public static void main(String[] args) {
        JavaVmStackSOF oom = new JavaVmStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }
}
