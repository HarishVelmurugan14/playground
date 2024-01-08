package javaLearn.classConcept.inheritance.Circle;

//Inheritance : To actually keeps items common to all under one hood aad use it

public class Circle {
    double radius;

    public Circle(double radius) {
        if (radius < 0) {
            radius = 0;
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return getRadius() * getRadius() * Math.PI;
    }
}
