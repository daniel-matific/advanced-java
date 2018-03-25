package mmn13.exercise1;

public enum Shapes {

    Circle(new Circle()),
    Line(new Line());

    private final Shape shape;

    private Shapes(Circle circle) {
        shape = circle;
    }
    
    private Shapes(Line line) {
        shape = line;
    }

    public Shape getShape() {
        return shape;
    }
}