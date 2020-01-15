package threadpool;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2020/1/15 0015
 * @Version： 1.0
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        MyFixedThreadPool myFixedThreadPool = new MyFixedThreadPool(5,3);

        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "个任务提交");
            myFixedThreadPool.submit(() ->{
                System.out.println( Thread.currentThread().getName() + "\t任务执行完成");
            });
        }
        myFixedThreadPool.stop();
    }
}
