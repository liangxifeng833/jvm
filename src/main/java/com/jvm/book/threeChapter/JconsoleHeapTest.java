package com.jvm.book.threeChapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Jconsole监视器测试
 * 堆内存不停地创建对象,测试代码
 */
public class JconsoleHeapTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64*1024];
    }
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i=0; i<num; i++)
        {
            //稍作延时
            Thread.sleep(50);
            System.out.println("新增OOMObject--"+i);
            list.add(new OOMObject());
        }
        System.out.println("回收前");
        System.gc();
        System.out.println("回收后");
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

}
