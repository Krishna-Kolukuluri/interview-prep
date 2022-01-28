package designpatterns.behavioural;
/*
https://www.journaldev.com/1739/observer-design-pattern-in-java
An observer design pattern is useful when you are interested in the state of an object and want to get notified whenever
there is any change. In observer pattern, the object that watches on the state of another object is called Observer and
the object that is being watched is called Subject.

Java provides an inbuilt platform for implementing Observer pattern through java.util.Observable class and java.util.Observer interface.
However, it’s not widely used because the implementation is really simple and most of the time we don’t want to end up
extending a class just for implementing Observer pattern as java doesn’t provide multiple inheritances in classes.

Java Message Service (JMS) uses Observer pattern along with Mediator pattern to allow applications to subscribe and publish
data to other applications. Check out Observer Pattern post for implementation details and example program
* */
public class ObserverPattern {
}
