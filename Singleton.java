
public class Singleton {
    private Singleton() {
        // 防止通过反射创建实例
        if (SingletonHolder.INSTANCE != null) {
            throw new RuntimeException("请使用 getInstance() 方法获取此类的单个实例。");
        }
    }

    // 静态内部类，用于持有单例实例
    private static class SingletonHolder {
        // 类加载时不会初始化此静态变量，只有当调用 getInstance 方法时才会加载
        private static final Singleton INSTANCE = new Singleton();
    }

    // 提供全局访问点，同时保证线程安全和懒加载
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // 示例方法
    public void showMessage() {
        System.out.println("单例模式！");
    }

    // 主方法，用于测试
    public static void main(String[] args) {
        // 获取单例对象并调用其方法
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
    }
}