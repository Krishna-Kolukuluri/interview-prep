package designpatterns.structural.decorator;
/*
Decorator design pattern is used to modify the functionality of an object at runtime. At the same time other instances
of the same class will not be affected by this, so individual object gets the modified behavior
* */
public class DecoratorPattern {
    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
