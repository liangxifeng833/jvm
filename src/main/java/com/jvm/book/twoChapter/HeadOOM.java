package com.jvm.book.twoChapter;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM参数配置：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 将堆的最小值Xms设置为20m,最大值设置为20m,最大值＝最小值即可避免堆自动扩充
 * 参数-XX:+HeapDumpOnOutOfMemoryError,当虚拟机出现内存溢出时，将信息打印出来
 * 测试堆内存溢出
 */
public class HeadOOM {
    static class OOMObject {
    }

    /**
     * 以下程序执行一会后会出现内存溢出情况
     * 溢出时的打印信息：Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
