package com.poiu.example.userRegister.observer;

/**
 * 赠送优惠券观察者
 *
 * @author: haibo.liang
 * @create: 2021-04-23 17:53
 **/
public class GiftCouponObserver implements BaseUserRegSuccessObserver {

    @Override
    public void afterSuccess(String phone) {
        // 业务代码
        System.out.println("GiftCouponObserver:GiftCoupon phone:" + phone);
    }
}
