package systemdesign.vendingmachine.model;
/*
*A parameterized utility class to hold two different object.
* */
public class Bucket<T1, T2> {
    private T1 t1;
    private T2 t2;

    public Bucket(T1 first, T2 second){
        this.t1 = first;
        this.t2 = second;
    }

    public T1 getFirst(){
        return t1;
    }
    public T2 getSecond(){
        return t2;
    }
}
