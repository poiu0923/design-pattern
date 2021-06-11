package com.poiu.pattern.create;

/**
 * 单例设计模式（Singleton Design Pattern）
 * 一个类只允许创建一个对象（或者实例），那这个类就是一个单例类，这种设计模式就叫作单例设计模式，简称单例模式。
 * <p>
 * 优势/解决问题
 * 1.处理资源范围冲突.
 * 2.表示全局唯一类
 *
 * @author: haibo.liang
 * @create: 2021-06-11 10:03
 **/
public class SingletonDesignPattern {
}

/**
 * 饿汉式
 * 在初始时刻就创建好类
 */
class HungrySingleton {
    private final static Object object = new Object();

    private HungrySingleton() {
    }

    public static Object getInstance() {
        return object;
    }
}

/**
 * 懒汉式
 * 在第一次需要的时候再实例化类
 * 采用双重检测锁保证线程安全
 */
class LazySingleton {
    private static volatile Object object = null;

    private LazySingleton() {
    }

    public static Object getInstance() {
        Object temp = object;
        if (temp == null) {
            synchronized (LazySingleton.class) {
                temp = object;
                if (temp == null) {
                    temp = new Object();
                    object = temp;
                }
            }
        }
        return temp;
    }
}

/**
 * 静态内部类
 * 利用 Java 的静态内部类来实现单例。这种实现方式，既支持延迟加载，也支持高并发，实现起来也比双重检测简单。
 */
class StaticInternalClassSingleton {
    private StaticInternalClassSingleton() {
    }

    private static class SingletonHolder {
        private static final Object instance = new Object();
    }

    public static Object getInstance() {
        return SingletonHolder.instance;
    }
}

/**
 * 枚举
 * 基于枚举类型的单例实现。这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性
 */
enum EnumSingleton {
    INSTANCE;
    private final Object object = new Object();

    public Object getInstance() {
        return object;
    }
}