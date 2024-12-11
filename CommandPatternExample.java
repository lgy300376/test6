public class CommandPatternExample {

    // 命令接口
    public interface Command {
        void execute();
        void undo();
    }

    // 接收者 - 实际执行动作的对象
    public static class Receiver {
        public void action() {
            System.out.println("执行操作");
        }

        public void unAction() {
            System.out.println("撤销操作");
        }
    }

    // 具体命令A - 实现了命令接口，并持有接收者
    public static class ConcreteCommandA implements Command {
        private final Receiver receiver;

        public ConcreteCommandA(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void execute() {
            receiver.action();
        }

        @Override
        public void undo() {
            receiver.unAction();
        }
    }

    // 调用者 - 持有命令并触发执行
    public static class Invoker {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void executeCommand() {
            if (command != null) {
                command.execute();
            }
        }

        public void undoCommand() {
            if (command != null) {
                command.undo();
            }
        }
    }

    // 测试代码
    public static void main(String[] args) {
        // 创建接收者
        Receiver receiver = new Receiver();

        // 创建具体命令，并关联接收者
        Command command = new ConcreteCommandA(receiver);

        // 创建调用者，并设置命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);

        // 执行命令
        invoker.executeCommand();

        // 撤销命令
        invoker.undoCommand();
    }
}