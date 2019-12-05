package com.jvm.book.twoChapter;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *
 * 虚拟机参数：-XX:PermSize=10M -XX:MaxPermSize=10M
 * 方法区内存溢出异常测试,也就是不停的创建新类，让其超出设定的10M
 * 借助CGLib使用方法区出现内存溢出异常
 * 书中的程序没有跑起来!!
 */
public class JavaMethodAreaOOM {
    static class OOMObject {
    }
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o,args);
                }
            });
            enhancer.create();
        }
    }
}
