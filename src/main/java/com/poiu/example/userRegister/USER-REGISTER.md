# 用户注册事件
#### 背景分析
用户注册事件是比较冗长的业务流程,可以拆分为主要业务和次要业务.
主要业务是用户注册,次要业务是注册后的一系列补充业务,并且因为业务是变化发展的,会一直进行修改和补充.
实际场景:用户注册后赠送用户积分,给用户发放新手优惠券;过一段时间后业务变更:用户注册后还需要赠送7天vip等等业务

#### 设计模式分析
- 选用设计模式:观察者模式
- 设计模式分析:

#### 代码实现
```text
userRegister
├── UserRegisterDemo(用户注册事件demo入口)
├── service(service业务实现类)
│   └── UserService(用户业务实现类,执行具体注册核心业务)
├── subject(主题类)
│   └── UserRegisterSubject(用户注册主题,对用户注册业务进行封装代理,实现观察者通知逻辑)
└── observer(观察者实现)
    ├── BaseUserRegSuccessObserver(用户注册后观察者接口,提供统一执行接口定义)
    ├── GiftPointsObserver(赠送积分具体实现类)
    ├── GiftCouponObserver(赠送优惠券具体实现类)
    └── GiftVIPObserver(赠送VIP具体实现类)
```