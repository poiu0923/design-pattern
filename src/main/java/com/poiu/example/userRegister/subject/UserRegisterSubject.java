package com.poiu.example.userRegister.subject;

import com.poiu.example.userRegister.observer.BaseUserRegSuccessObserver;
import com.poiu.example.userRegister.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户注册主题
 *
 * @author: haibo.liang
 * @create: 2021-04-23 17:50
 **/
public class UserRegisterSubject {

    // 用户service, 在spring框架中可以通过 @Autowired 自动注入
    private final UserService userService;

    // 观察者列表
    private final List<BaseUserRegSuccessObserver> observerList = new ArrayList<>();

    public UserRegisterSubject(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册事件
     * 实际上应用的是静态代理
     *
     * @param phone
     */
    public void userRegister(String phone) {
        // 调用用户service进行用户注册
        userService.register(phone);

        // 通知所有已注册观察者
        observerList.forEach(e -> e.afterSuccess(phone));
    }

    /**
     * 注册观察者
     *
     * @param observer
     */
    public void register(BaseUserRegSuccessObserver observer) {
        this.observerList.add(observer);
    }

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void remove(BaseUserRegSuccessObserver observer) {
        this.observerList.remove(observer);
    }
}
