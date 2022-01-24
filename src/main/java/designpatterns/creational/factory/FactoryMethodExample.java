package designpatterns.creational.factory;
/*
The factory design pattern is used when we have a superclass with multiple sub-classes and based on input, we need to
return one of the sub-class. This pattern takes out the responsibility of the instantiation of a class from the client program to the factory class.
* */
public class FactoryMethodExample {
    public static void main(String[] args) {
        Person male = PersonFactory.getPerson("Krishna", "M");
        System.out.println(male.getNameAndSalutation());

        Person female = PersonFactory.getPerson("Deepthi", "F");
        System.out.println(female.getNameAndSalutation());
    }
}

class PersonFactory{
    public static Person getPerson(String name, String gender){
        if(gender.equalsIgnoreCase("M")){
            return new Male(name);
        }
        else if(gender.equalsIgnoreCase("F")){
            return new Female(name);
        }
        return null;
    }
}

abstract class Person{
    Person(String name){
        this.name = name;
    }
    private String name;

    abstract String getSalutation();

    String getNameAndSalutation(){
        return  getSalutation() + name;
    }

}

class Male extends Person{
    public Male(String name){
        super(name);
    }

    @Override
    String getSalutation() {
        return "Mr.";
    }
}

class Female extends Person{
    public Female(String name){
        super(name);
    }

    @Override
    String getSalutation() {
        return "Miss/Mrs.";
    }

}
