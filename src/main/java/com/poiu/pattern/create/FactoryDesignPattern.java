package com.poiu.pattern.create;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式
 * 当创建逻辑比较复杂，是一个“大工程”的时候，我们就考虑使用工厂模式，封装对象的创建过程，将对象的创建和使用相分离
 *
 * @author: haibo.liang
 * @create: 2021-06-17 19:23
 **/
public class FactoryDesignPattern {
    /**
     * 使用工厂模式获取处理器对象
     *
     * @param args
     */
    public static void main(String[] args) {
        HandlerFactory handlerFactory = HandlerFactoryMap.getFactory("A");
        Handler handler = handlerFactory.createHandler();
        handler.handle();
    }
}

/**
 * 处理器接口
 */
interface Handler {
    void handle();
}

/**
 * 处理器A
 */
class ConcreteHandlerA implements Handler {
    @Override
    public void handle() {
        System.out.println("ConcreteHandlerA handle()");
    }
}

/**
 * 处理器B
 */
class ConcreteHandlerB implements Handler {
    @Override
    public void handle() {
        System.out.println("ConcreteHandlerB handle()");
    }
}

/**
 * 处理器简单工厂
 */
class HandlerSimpleFactory {
    public static Handler createHandler(String type) {
        Handler handler = null;
        if ("A".equals(type)) {
            handler = new ConcreteHandlerA();
        } else if ("B".equals(type)) {
            handler = new ConcreteHandlerB();
        }

        return handler;
    }
}

/**
 * 处理器工厂接口
 */
interface HandlerFactory {
    Handler createHandler();
}

/**
 * 处理器A的工厂
 */
class HandlerAFactory implements HandlerFactory {
    @Override
    public Handler createHandler() {
        return new ConcreteHandlerA();
    }
}

/**
 * 处理B的工厂
 */
class HandlerBFactory implements HandlerFactory {
    @Override
    public Handler createHandler() {
        return new ConcreteHandlerB();
    }
}

/**
 * 处理器工厂类的工厂类
 */
class HandlerFactoryMap {
    private static final Map<String, HandlerFactory> FACTORY_MAP = new HashMap<>();

    static {
        FACTORY_MAP.put("A", new HandlerAFactory());
        FACTORY_MAP.put("B", new HandlerBFactory());
    }

    public static HandlerFactory getFactory(String type) {
        HandlerFactory handlerFactory = FACTORY_MAP.get(type);
        if (handlerFactory == null) {
            throw new RuntimeException("HandlerFactory not found");
        }
        return handlerFactory;
    }
}