package offer;

/**
 * 单例模式，懒加载模式
 */
public class SingletonLazy {
    private SingletonLazy() {}
    //实例定义为私有，只能通过getInstance访问
    //定义为静态，在静态的get方法中可以访问 因为该类构造函数为私有，外部无法创建类的实例，只能通过类访问
    //volatile禁止指令冲排序
    //new 对象的过程：
    //1.给实例分配内存
    //2.初始化实例
    //3.将instance指向分配的内存
    //2.3可能发生冲排序，使得线程A仍在new instance的过程，线程B已经检测到instance != null，返回为空的对象
    private volatile static  SingletonLazy instance = null;

    /**
     * 未考虑线程安全的懒汉模式
     */
    public static SingletonLazy getInstance() {
        if(instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 加锁，每次进入getInstance都要同步，性能低（其实只需要在多线程同时创建对象时同步，只需创建一次）
     */
    public static synchronized SingletonLazy getInstance2() {
        if(instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 双重检测机制
     */
    public static SingletonLazy getInstance3() {
        //只在instance为空，需要创建时才进入同步代码块
        if(instance == null) {
            //类对象加锁
            synchronized (SingletonLazy.class) {
                //第二次检测，可能当线程A进入同步块创建后，线程B阻塞在外，A释放后，B直接进入，B需要检测对象是否已经创建
                if(instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
