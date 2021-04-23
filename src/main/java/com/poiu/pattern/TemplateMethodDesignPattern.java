package com.poiu.pattern;

/**
 * 模板模式:模板方法模式在一个方法中定义一个算法骨架，并将某些步骤推迟到子类中实现。模板方法模式可以让子类在不改变算法整体结构的情况下，重新定义算法中的某些步骤。
 * 模板方法模式在一个方法中定义一个算法骨架，并将某些步骤推迟到子类中实现。模板方法模式可以让子类在不改变算法整体结构的情况下，重新定义算法中的某些步骤。
 * 模板模式有两大作用：复用和扩展。其中，复用指的是，所有的子类可以复用父类中提供的模板方法的代码。扩展指的是，框架通过模板模式提供功能扩展点，让框架用户可以在不修改框架源码的情况下，基于扩展点定制化框架的功能。
 *
 * @author: haibo.liang
 * @create: 2021-04-23 12:39
 **/
public class TemplateMethodDesignPattern {
    public static void main(String[] args) {
        AbstractClass abstractClassOne = new ConcreteClassOne();
        abstractClassOne.templateMethod();

        AbstractClass abstractClassTwo = new ConcreteClassTwo();
        abstractClassTwo.templateMethod();
    }
}

/**
 * 模板类
 */
abstract class AbstractClass {

    /**
     * 模板方法,定义算法逻辑
     * 定义为final防止子类重写,但是实际业务中需要根据实际情况定义
     */
    public final void templateMethod() {
        // 调用方法一
        methodOne();

        // 调用方法二
        methodTwo();
    }

    // 具体算法实现,模板类中不实现具体细节,交由具体子类进行实现
    protected abstract void methodOne();
    protected abstract void methodTwo();
}

/**
 * 实现子类1
 */
class ConcreteClassOne extends AbstractClass {
    @Override
    protected void methodOne() {
        System.out.println("ConcreteClassOne methodOne");
    }

    @Override
    protected void methodTwo() {
        System.out.println("ConcreteClassOne methodTwo");
    }
}

/**
 * 实现子类2
 */
class ConcreteClassTwo extends AbstractClass {
    @Override
    protected void methodOne() {
        System.out.println("ConcreteClassTwo methodOne");
    }

    @Override
    protected void methodTwo() {
        System.out.println("ConcreteClassTwo methodTwo");
    }
}