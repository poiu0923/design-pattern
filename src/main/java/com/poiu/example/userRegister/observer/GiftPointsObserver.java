package com.poiu.example.userRegister.observer;

/**
 * 赠送积分观察者
 *
 * @author: haibo.liang
 * @create: 2021-04-23 17:53
 **/
public class GiftPointsObserver implements BaseUserRegSuccessObserver {

    @Override
    public void afterSuccess(String phone) {
        // 业务代码
        System.out.println("GiftPointsObserver:GiftPoints phone:" + phone);
    }
}
