package com.jvm.book.threeChapter;

/**
 * 即使有相互引用关系，仍然会被回收掉
 */
public class ReferenceCountingGc {
    public Object instance = null;
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];

    public static void main(String[] args) {
        ReferenceCountingGc objA = new ReferenceCountingGc();
        ReferenceCountingGc objB = new ReferenceCountingGc();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        System.gc();
    }

}
