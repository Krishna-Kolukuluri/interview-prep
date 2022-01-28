package designpatterns.structural.proxy;
/*
* Proxy design pattern common uses are to control access or to provide a wrapper implementation for better performance.
Java RMI package uses proxy pattern. That’s all for proxy design pattern in java.
* */
public class ProxyPattern {
    public static void main(String[] args){
        CommandExecutor executor = new CommandExecutorProxy("Krishna", "pwd_wrong");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::"+e.getMessage());
        }

    }
}
