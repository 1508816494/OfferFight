package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Combo{
    private List<Integer> list = new ArrayList<>(3);
    float f = 0.2f;
    Long l = 1000L;

    public int getId(int index) {
        return list.get(index);
    }

    public static void main(String[] args) {
        Product A = new Product(1,"A",1024);
        Product B = new Product(2,"B",9000);
        Product C = new Product(3,"C",10000);

        Combo combo = new Combo();
        combo.list.add(1);
        combo.list.add(2);
        combo.list.add(3);

        int j = -4;
        j >>>= 1;
        System.out.println("j="+j);

        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.offer(combo.getId(0));

        while (!queue.isEmpty()) {
            final int currentId = queue.poll();
            new Thread(()->{
                Product p = ProductService.ProductQueryInfo(currentId);
                if(currentId == 1) {
                    queue.offer(1);
                } else if(currentId == 2) {
                    queue.offer(2);
                }

            }).start();
        }


        //线程池无法保证顺序执行，除非单线程线程池，可以按照任务提交顺序执行
//        ExecutorService pool = Executors.newCachedThreadPool();

//        for(int i = 0; i < 3; i++) {
//            final int index = i;
//            pool.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    System.out.println("task:{}"+ index);
//
//                }
//            });
//        }
//        pool.shutdown();
    }

}
