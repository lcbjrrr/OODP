package acme;

public class App {
    private static App app;
    private StudentManager studentManager;
    private App(RepositoriesAbstractFactory factory){
        IStudentRepository repo = factory.getStudentRepository();
        this.studentManager = new StudentManager(repo);
    }
    public static App getInstance(RepositoriesAbstractFactory factory){
        if(app == null){
            app = new App(factory);
        }
        return app;
    }
}
