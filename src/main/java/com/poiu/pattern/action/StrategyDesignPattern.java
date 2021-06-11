package com.poiu.pattern.action;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略模式:定义一族算法类，将每个算法分别封装起来，让它们可以互相替换。策略模式可以使算法的变化独立于使用它们的客户端（这里的客户端代指使用算法的代码）
 *
 * @author: haibo.liang
 * @create: 2021-04-23 13:53
 **/
public class StrategyDesignPattern {
    public static void main(String[] args) {
        // 注册策略
        StrategyFactory strategyFactory = new StrategyFactory();
        strategyFactory.registerStrategy("A", new ConcreteStrategyA());
        strategyFactory.registerStrategy("B", new ConcreteStrategyB());

        // 获取具体策略并执行
        Strategy strategyA = strategyFactory.getStrategyByKey("A");
        strategyA.doMain();

        Strategy strategyB = strategyFactory.getStrategyByKey("B");
        strategyB.doMain();
    }
}

/**
 * 策略接口
 */
interface Strategy {
    void doMain();
}

/**
 * 策略工厂
 * 策略的创建由工厂类来完成，封装策略创建的细节。
 */
class StrategyFactory {
    private final Map<String, Strategy> map = new HashMap<>();

    public void registerStrategy(String key, Strategy strategy) {
        map.put(key, strategy);
    }

    public Strategy getStrategyByKey(String key) {
        return map.get(key);
    }
}

/**
 * 策略具体实现A
 */
class ConcreteStrategyA implements Strategy {
    @Override
    public void doMain() {
        System.out.println("ConcreteStrategyOne doMain");
    }
}

/**
 * 策略具体实现B
 */
class ConcreteStrategyB implements Strategy {
    @Override
    public void doMain() {
        System.out.println("ConcreteStrategyTwo doMain");
    }
}
