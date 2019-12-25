package com.jvm.book.eightChapter;

/**
 * 单分派，多分派演示
 * java语言是静态多分派，动态单分派语言
 */
public class Dispatch {
    static class QQ{};
    static class _360{};
    public static class Father{
        public void hardChoice(QQ arg) {
            System.out.println("father choice qq");
        }
        public void hardChoice(_360 arg) {
            System.out.println("father choice 360");
        }
    }
    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choice qq");
        }
        public void hardChoice(_360 arg) {
            System.out.println("son choice 360");
        }
    }

    /**
     * 输出：
     * father choice 360
     * son choice qq
     */
    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
