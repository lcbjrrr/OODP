package shapes;

public class Triangle implements Shape{
    double base;
    double height;
    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    public double area(){
        return (base*height)/2;
    }
}
