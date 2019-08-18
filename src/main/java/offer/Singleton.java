package offer;

/**
 * 单例模式：饥饿模式
 */
public class Singleton {
    //构造函数私有
    private Singleton() {

    }
    //饥饿模式 类加载初期就会创建，避免多线程安全问题 缺点：未用到也会被创建
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}
