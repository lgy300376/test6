public class SimpleFactory {

    // 抽象产品接口
    public interface Product {
        void showProductInfo();
    }

    // 具体产品A
    public static class ConcreteProductA implements Product {
        @Override
        public void showProductInfo() {
            System.out.println("华为手机");
        }
    }

    // 具体产品B
    public static class ConcreteProductB implements Product {
        @Override
        public void showProductInfo() {
            System.out.println("小米手机");
        }
    }

    // 静态工厂方法，根据参数决定创建哪个具体产品
    public static Product createProduct(String type) {
        switch (type.toLowerCase()) {
            case "h":
                return new ConcreteProductA();
            case "x":
                return new ConcreteProductB();
            default:
                throw new IllegalArgumentException("手机工厂: " + type);
        }
    }

    // 测试代码
    public static void main(String[] args) {
        // 使用静态工厂方法创建产品A
        Product productA = SimpleFactory.createProduct("h");
        productA.showProductInfo();

        // 使用静态工厂方法创建产品B
        Product productB = SimpleFactory.createProduct("x");
        productB.showProductInfo();
    }
}
