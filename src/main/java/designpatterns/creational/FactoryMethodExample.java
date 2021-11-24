package designpatterns.creational;

public class FactoryMethodExample {
    public static class PersonFactory{
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

    public static void main(String[] args) {
        Person male = PersonFactory.getPerson("Krishna", "M");
        System.out.println(male.getNameAndSalutation());

        Person female = PersonFactory.getPerson("Deepthi", "F");
        System.out.println(female.getNameAndSalutation());
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
