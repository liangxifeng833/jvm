package com.jvm.book.eightChapter;

/**
 * 方法动态分派演示 (方法重写)
 * 运行期间,通过实际类型确定方法执行版本的分派过程称为动态分派
 * @author lxf 2019-12-25
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }
    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello!");
        }
    }
    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say Hello!");
        }
    }
    /**
     * 输出：
     * man say hello!
     * woman say Hello!
     * woman say Hello!
     * @param args
     */
    public static void main(String[] args) {
        //Human 称为静态类型，Man称为实际类型
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
