package com.jvm.book.threeChapter;

import org.junit.Test;

/**
 * 新生代MinorGC测试
 */
public class EdenAllocationTest {
    private static final int _1MB = 1024*1024;
    /**
     * JVM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2,allocation3,allocation4;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation4 = new byte[4*_1MB];
    }

    /**
     * 测试超过PretenureSizeThreshold值的对象直接分配到老年代
     * JVM参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M
     * -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728 (3M)
     */
    @Test
    public void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4*_1MB];
    }

    /**
     * 空间分配担保,只要老年代连续空间大于新生代对象总大小或历次晋升的平均大小就会进行ＭinorＧGC，否则将进行FullGC;
     * JVM参数：
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M
     * -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:+UseSerialGC -XX:MaxTenuringThreshold=15
     */
    @Test
    public void testTenuringThresholdNew() {
        byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6,allocation7;
        allocation1 = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation1 = null;
        allocation4 = new byte[2*_1MB];
        allocation5 = new byte[2*_1MB];
        allocation6 = new byte[2*_1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
}
