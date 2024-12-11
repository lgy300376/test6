public class DecoratorPatternExample {

    // 抽象组件 - 定义了所有具体组件和装饰器的共同接口
    public interface Component {
        void operation();
    }

    // 具体组件 - 实现了抽象组件接口
    public static class ConcreteComponent implements Component {
        @Override
        public void operation() {
            System.out.println("具体组件的操作");
        }
    }

    // 抽象装饰器 - 持有一个组件类型的引用，并实现了组件接口
    public static abstract class Decorator implements Component {
        protected Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            if (component != null) {
                component.operation();
            }
        }
    }

    // 具体装饰器A - 给组件添加额外的行为
    public static class ConcreteDecoratorA extends Decorator {
        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();  // 调用原有操作
            addBehaviorA();     // 添加新行为
        }

        private void addBehaviorA() {
            System.out.println("装饰器A添加的行为");
        }
    }

    // 具体装饰器B - 给组件添加其他额外的行为
    public static class ConcreteDecoratorB extends Decorator {
        public ConcreteDecoratorB(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();  // 调用原有操作
            addBehaviorB();     // 添加新行为
        }

        private void addBehaviorB() {
            System.out.println("装饰器B添加的行为");
        }
    }

    // 测试代码
    public static void main(String[] args) {
        // 创建具体组件
        Component component = new ConcreteComponent();

        // 使用装饰器包装组件
        Component decoratedA = new ConcreteDecoratorA(component);
        Component decoratedAB = new ConcreteDecoratorB(decoratedA);

        // 执行被装饰后的组件操作
        decoratedAB.operation();
    }
}