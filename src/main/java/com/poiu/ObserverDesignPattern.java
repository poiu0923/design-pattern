package com.poiu;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
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