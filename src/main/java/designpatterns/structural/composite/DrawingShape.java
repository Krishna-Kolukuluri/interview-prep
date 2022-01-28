package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class DrawingShape implements  Shape{
    private List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String fillColor) {
        shapes.stream().forEach(shape -> shape.draw(fillColor));
    }

    //adding shape to drawing
    public void add(Shape s){
        this.shapes.add(s);
    }

    //removing shape from drawing
    public void remove(Shape s){
        shapes.remove(s);
    }

    //removing all the shapes
    public void clear(){
        System.out.println("Clearing all the shapes from drawing");
        this.shapes.clear();
    }
}
