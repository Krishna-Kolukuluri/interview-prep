package concepts;

public class AbstractInterfaceExample {
}

interface InterfaceExample{
    //Interfaces can have static concrete methods along with abstract methods from Java 8.
    static int getCount(int num){
        num  += 1;
        return num;
    }

    //default(access modifier), concrete methods along with abstract methods from Java 8.
    default String concatNames(String firstName, String lastName) {
        return null;
    }

    //Abstract method
    boolean isValidName(String name);
}

//Abstract class with constructor, concrete methods, attributes/instance variables and abstract method.
abstract class  abstractExample{
    private int count = 0;
    public abstractExample(){
        setCount(getCount() + 1);
    }

    public int getCount(){
        return count;
    }
    public void setCount(int tempCount){
        this.count = tempCount;
    }
    abstract int calculateCount(int localCount);
}
