public class Square extends Shape {
    double side;
    public Square(double side) {
        this.side = side;
    }
    double area(){
        return side*side;
    }
}
