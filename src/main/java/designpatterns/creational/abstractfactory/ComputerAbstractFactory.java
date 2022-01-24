package designpatterns.creational.abstractfactory;
/*
* Abstract Factory pattern is almost similar to Factory Pattern except the fact that its more like factory of factories.
* Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products,
* for example we can add another sub-class Laptop and a factory LaptopFactory
* */
public interface ComputerAbstractFactory {
    public Computer createComputer();
}
