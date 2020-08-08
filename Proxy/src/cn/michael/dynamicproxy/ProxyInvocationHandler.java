package cn.michael.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        Object result = method.invoke(target, args);
        agencyFee();
        return result;
    }

    public void seeHouse(){
        System.out.println("See House");
    }

    public void agencyFee(){
        System.out.println("Agency Fee.");
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
