package com.poiu.example.userRegister.observer;

/**
 * 赠送VIP观察者
 *
 * @author: haibo.liang
 * @create: 2021-04-23 17:53
 **/
public class GiftVIPObserver implements BaseUserRegSuccessObserver {

    @Override
    public void afterSuccess(String phone) {
        // 业务代码
        System.out.println("GiftVIPObserver:GiftVIP phone:" + phone);
    }
}
