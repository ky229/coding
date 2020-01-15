package myaop.simple;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2020/1/9 0009
 * @Version： 1.0
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHelloWorld() {
        System.out.println("hello world!");
    }
}
