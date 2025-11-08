package acme;

public class App {
    private static App app;
    private StudentManager studentManager;
    private RepositoriesAbstractFactory factory;
    public App(RepositoriesAbstractFactory factory){
        this.factory = factory;
        IStudentRepository repo = factory.getStudentRepository();
        //IStudentRepository repo = new StudentRepositoryDB();
        this.studentManager = new StudentManager(repo);
    }

}
