package com.poiu.example.userRegister.observer;

/**
 * 用户注册后观察者接口
 *
 * @author: haibo.liang
 * @create: 2021-04-23 17:51
 **/
public interface BaseUserRegSuccessObserver {
    void afterSuccess(String phone);
}
