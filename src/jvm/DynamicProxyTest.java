package jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理简单演示
 */
public class DynamicProxyTest {
    interface IHello{
        void sayHello();
        void sayGoodBye();
    }
    static class Hello implements IHello{
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }

        @Override
        public void sayGoodBye() {
            System.out.println("goodbye");
        }
    }
    static class DynamicProxy implements InvocationHandler{
        Object originalObj;
        Object bind(Object originalObj){
            this.originalObj=originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),originalObj.getClass().getInterfaces(),this);
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj,args);
        }
    }

    public static void main(String[] args) {
        IHello iHello=(IHello)new DynamicProxy().bind(new Hello());
        iHello.sayHello();
        iHello.sayGoodBye();
    }
}
