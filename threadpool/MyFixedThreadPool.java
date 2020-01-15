package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description:
 * @Author: 吴开云
 * @Date: 2020/1/15 0015
 * @Version： 1.0
 */
public class MyFixedThreadPool {
    //阻塞队列 -- 存放任务
    BlockingQueue<Runnable> taskQueue;

    //普通队列 -- 存放线程子类
    List<Works> workList;

    //线程池运行状态
    private volatile Boolean poolStatus;

    //自定义线程子类  --  执行任务
    class Works extends Thread{
        @Override
        public void run() {
            //如果线程池处于运行状态 || 任务队列未处理完成
            while (poolStatus || taskQueue.size() > 0){
                //当线程池处于运行状态时
                Runnable runnable = null;
                if(poolStatus){
                    //从队列中阻塞式 提取任务
                    try {
                        runnable  = (Runnable) taskQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    //非阻塞式 提取任务
                    runnable = (Runnable) taskQueue.poll();
                }
                //运行任务 run() 方法
                if (runnable != null){
                    System.out.println("自定义线程池 " + currentThread().getName() + "开始执行\t");
                    runnable.run();
                }
            }
        }
    }

    //构造函数 -- 线程池大小  任务数大小
    public MyFixedThreadPool(int taskSize, int poolSize) {
        if(taskSize <= 0 || poolSize <= 0){
            throw new IllegalArgumentException("非法参数");
        }
        //初始化线程池状态
        this.poolStatus = true;
        //初始化任务池
        taskQueue = new <Runnable>ArrayBlockingQueue(taskSize);
        //初始化线程队列
        workList = new ArrayList(poolSize);
        for (int i = 0; i < poolSize; i++) {
            Works works = new Works();
            workList.add(works);
            works.start();
        }
    }

    //任务提交方法
    public Boolean submit(Runnable runnable){
        //当线程池处于运行状态时 阻塞式 提交任务
        if(this.poolStatus){
            try {
                taskQueue.offer(runnable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    };

    //任务停止方法
    public Boolean stop(){
        //修改线程池状态
        this.poolStatus = false;
        //当线程队列中，已经有线程处于阻塞时，手动停止
        for (int i = 0; i < workList.size(); i++) {
            if(workList.get(i).getState().equals(Thread.State.BLOCKED)){
                workList.get(i).interrupt();
            }
        }
        return true;
    }
}
