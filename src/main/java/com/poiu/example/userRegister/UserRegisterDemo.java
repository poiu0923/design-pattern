package com.poiu.example.userRegister;

import com.poiu.example.userRegister.observer.GiftCouponObserver;
import com.poiu.example.userRegister.observer.GiftPointsObserver;
import com.poiu.example.userRegister.observer.GiftVIPObserver;
import com.poiu.example.userRegister.service.UserService;
import com.poiu.example.userRegister.subject.UserRegisterSubject;

/**
 * 用户注册事件demo
 *
 * @author: haibo.liang
 * @create: 2021-04-23 18:04
 **/
public class UserRegisterDemo {
    public static void main(String[] args) {
        // 手动配置
        // 在spring boot框架中,观察者实现类可以通过实现InitializingBean接口并重写afterPropertiesSet()方法,在bean创建完成后自动注册进subject中
        UserRegisterSubject userRegisterSubject = new UserRegisterSubject(new UserService());
        userRegisterSubject.register(new GiftPointsObserver());
        userRegisterSubject.register(new GiftCouponObserver());
        userRegisterSubject.register(new GiftVIPObserver());

        // 进行注册事件
        userRegisterSubject.userRegister("18888888888");
    }
}
