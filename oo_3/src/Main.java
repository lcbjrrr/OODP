//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Shape[] figs= new Shape[3];
        figs[0] = new Circle(5);
        figs[1] = new Square(5);
        figs[2] = new Triangle(5,5);

        for (Shape f : figs){
            System.out.println(f.area());
        }
    }
}