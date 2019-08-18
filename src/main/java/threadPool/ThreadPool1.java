package threadPool;

import java.util.concurrent.*;


public class ThreadPool1 {
    public static void main(String[] args) {
        /**
         * ThreadPoolExecutor
         * 几种参数：
         * corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit, BlockingQueue, rejectHandler
         * 返回值为ThreadPoolExecutor
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10, 15, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        for(int i = 0; i < 10; i++) {
            final int index = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task:" + index);
                }
            });
        }

        /**
         * 按需创建线程，调用ThreadPoolExecutor core为0，max=Integer.MAX_VALUE
         * SynchronousQueue 每个 put 必须等待一个 take
         * 内部没有任何容量的阻塞队列，任何一次插入操作的元素都要等待相对的删除/读取操作，否则进行插入操作的线程就要一直等待，反之亦然。
         */
        ExecutorService executorService1 = Executors.newCachedThreadPool();

        /**
         * 固定线程数，core = max = num
         * blocking queue = new LinkedBlockingQueue()无限长的queue
         */
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);

        /**
         * 单线程线程池，按任务提交顺序执行
         * core = max = 1
         * LinkedBlockingQueue
         */
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        /**
         * 可按给定延时执行
         */
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        /*
         * 延迟执行
         */
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行啦----");
            }
        }, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("do****");
            }
        }, 1, 2, TimeUnit.SECONDS);









    }
}
