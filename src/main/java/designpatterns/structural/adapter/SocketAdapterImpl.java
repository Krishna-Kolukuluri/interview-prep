package designpatterns.structural.adapter;
/* https://www.journaldev.com/1487/adapter-design-pattern-java
* Adapter design pattern is one of the structural design pattern and its used so that two unrelated interfaces can work
* together. The object that joins these unrelated interface is called an Adapter.
* */
/*
* Here is the class adapter approach implementation of our adapter.
* */
public class SocketAdapterImpl extends Socket implements SocketAdapter{
    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolt();
        return convertVolt(v, 40);
    }
    private Volt convertVolt(Volt v, int i){
        return new Volt(v.getVolts()/i);
    }
}
/*
* Here is the Object adapter implementation of our adapter.
* */
class SocketAdapterImpl2 implements SocketAdapter{
    Socket socket = new Socket();
    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 40);
    }
    private Volt convertVolt(Volt v, int i){
        return new Volt(v.getVolts()/i);
    }
}
