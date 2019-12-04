package com.jvm.book.twoChapter;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM参数：-XX:PermSize=10M -XX:MaxPermSize=10M
 * 因为常量池分配在永久代
 * 所以PermSize和MaxPermSize分配配置的是永久代内存初始大小和最大值
 * 运行时候常量池导致的内存溢出异常
 *
 */
public class RuntimeConstantPoolOOM {
    /**
     * 执行本方法会出现如下异常：
     * java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {
        //使用List保持着常量池引用,避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        //10M的PermSize在integer范围内足够产生OOM了；
        int i = 0;
        //intern()方法将String类型的实例放入到常量池中
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
