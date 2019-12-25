package com.jvm.book.eightChapter;

/**
 * 方法静态分派演示 (方法重载)
 * 依据静态类型来定位方法执行版本的分派称为静态分派
 */
public class StaticDispatch {
    static abstract class Human{}
    static class Man extends Human {}
    static class Woman extends Human {}

    public static void sayHello(Human guy) {
        System.out.println("hello, guy!");
    }
    public static void sayHello(Man guy) {
        System.out.println("hello, gentlemen!");
    }
    public static void sayHello(Woman guy) {
        System.out.println("hello, lady!");
    }

    /**
     * 输出结果：
     * hello, guy!
     * hello, guy!
     */
    public static void main(String[] args) {
        //Human为静态类型，Man为实际类型
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
}
