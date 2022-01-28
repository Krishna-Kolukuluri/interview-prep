package designpatterns.structural.composite;

/*
* https://www.journaldev.com/1535/composite-design-pattern-in-java
* Composite Pattern consists of following objects.

* Base Component – Base component is the interface for all objects in the composition, client program uses base component
    to work with the objects in the composition. It can be an interface or an abstract class with some methods common to all the objects.
* Leaf – Defines the behaviour for the elements in the composition. It is the building block for the composition and
    implements base component. It doesn’t have references to other Components.
* Composite – It consists of leaf elements and implements the operations in base component.
* */
public class CompositePattern {
    public static void main(String[] args) {
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        DrawingShape drawing = new DrawingShape();
        drawing.add(tri1);
        drawing.add(tri1);
        drawing.add(cir);

        drawing.draw("Red");

        drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }
}
