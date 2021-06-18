package com.poiu.pattern.structure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式
 * 代理模式（Proxy Design Pattern）：它在不改变原始类（或叫被代理类）代码的情况下，通过引入代理类来给原始类附加功能。
 *
 * @author: haibo.liang
 * @create: 2021-06-18 10:55
 **/
public class ProxyDesignPattern {
    public static void main(String[] args) {
        UserService userService = (UserService) UserServiceDynamicProxy.createProxy(new UserServiceImpl());
        userService.login("jack", "1234");
    }
}

/**
 * 返回vo对象
 */
class UserVO {
    Integer id;
    String userName;
}

/**
 * 业务接口
 */
interface UserService {
    UserVO login(String userName, String password);
}

/**
 * 实际业务对象
 */
class UserServiceImpl implements UserService {
    @Override
    public UserVO login(String userName, String password) {
        System.out.println("UserServiceImpl.login username=" + userName + ", password=" + password);
        UserVO userVO = new UserVO();
        userVO.id = 1;
        userVO.userName = userName;
        return userVO;
    }
}

/**
 * 静态代理对象,通过继承实际业务对象并重写需要代理的方法实现
 */
class UserServiceProxy extends UserServiceImpl {
    UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserVO login(String userName, String password) {
        System.out.println("[proxy before] UserServiceProxy.login username=" + userName + ", password=" + password);

        // 委托
        UserVO userVO = userService.login(userName, password);

        System.out.println("[proxy after] UserServiceProxy.login username=" + userName + ", password=" + password);
        return userVO;
    }
}

class UserServiceDynamicProxy {
    /**
     * 创建代理对象
     *
     * @param proxiedObject 实际业务对象
     * @return 代理对象
     */
    public static Object createProxy(Object proxiedObject) {
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        Class[] interfaces = proxiedObject.getClass().getInterfaces();
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    /**
     * 代理实现,通过java反射执行方法
     */
    private static class DynamicProxyHandler implements InvocationHandler {
        private final Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("[proxy before] UserServiceDynamicProxy");

            // 委托
            Object result = method.invoke(proxiedObject, args);

            System.out.println("[proxy after] UserServiceDynamicProxy");
            return result;
        }
    }
}

