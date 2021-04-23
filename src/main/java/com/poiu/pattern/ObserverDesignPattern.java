package com.poiu.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式: 在对象之间定义一个一对多的依赖，当一个对象状态改变的时候，所有依赖的对象都会自动收到通知。
 * 一般情况下，被依赖的对象叫作被观察者（Observable），依赖的对象叫作观察者（Observer）。
 *
 * 观察者模块可以将同一个冗长业务的不同行为进行解耦,也就是将观察者和被观察者代码解耦
 * 举例适用业务场景:用户注册事件,注册后触发不同的权益事件,比如用户注册赠送积分,赠送优惠券,发送注册成功短信,发送数据统计等等
 * 在设计上,用户注册就是被观察者,后续不同的事件就是观察者
 *
 * @author: haibo.liang
 * @create: 2021-04-21 14:59
 **/
public class ObserverDesignPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();

        Observer observerOne = new ConcreteObserverOne();
        subject.registerObserver(observerOne);

        Observer observerTwo = new ConcreteObserverTwo();
        subject.registerObserver(observerTwo);

        NotifyMessage notifyMessage = new NotifyMessage();
        notifyMessage.message = "test notifyMessage";
        subject.notifyObserver(notifyMessage);
    }
}

/**
 * 通知消息内容
 */
class NotifyMessage {
    String message;
}

/**
 * 观察者接口,提供通知方法
 */
interface Observer {
    void notify(NotifyMessage notifyMessage);
}

/**
 * 通知主题
 */
interface Subject {
    // 注册观察者
    void registerObserver(Observer observer);

    // 移除观察者
    void removeObserver(Observer observer);

    // 通知观察者
    void notifyObserver(NotifyMessage notifyMessage);
}

/**
 * 通知主题具体实现类
 */
class ConcreteSubject implements Subject {
    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(NotifyMessage notifyMessage) {
        // 通知到所有已注册的观察者
        observerList.forEach(e -> e.notify(notifyMessage));
    }
}

/**
 * 观察者具体实现,需要实现通知后的业务
 */
class ConcreteObserverOne implements Observer {
    @Override
    public void notify(NotifyMessage notifyMessage) {
        System.out.println("ConcreteObserverOne notify, message = " + notifyMessage.message);
    }
}

/**
 * 观察者具体实现,需要实现通知后的业务
 */
class ConcreteObserverTwo implements Observer {
    @Override
    public void notify(NotifyMessage notifyMessage) {
        System.out.println("ConcreteObserverTwo notify, message = " + notifyMessage.message);
    }
}