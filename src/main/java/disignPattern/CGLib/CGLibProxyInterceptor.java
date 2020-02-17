package disignPattern.CGLib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxyInterceptor implements MethodInterceptor {
    /**
     *
     * @param o  生成的代理对象
     * @param method  被代理对象的方法
     * @param objects  方法入参
     * @param methodProxy  代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行前----------");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("执行后----------");
        return object;
    }
}
