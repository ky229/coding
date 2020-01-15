package myaop.simple;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2020/1/9 0009
 * @Version： 1.0
 */
public class SimpleAOP {
    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
                bean.getClass().getInterfaces(), advice);
    }
}
