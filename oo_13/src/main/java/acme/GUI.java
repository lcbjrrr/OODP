package acme;

public class GUI {
    private App app;
    public GUI(RepositoriesAbstractFactory factory){
        app = App.getInstance(factory);
    }
    public void run(){
        System.out.println("App up and running!");
    }
}
