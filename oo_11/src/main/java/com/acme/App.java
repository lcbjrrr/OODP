package acme;

public class App {
    private static App app;
    private StudentManager studentManager;
    private RepositoriesAbstractFactory factory;
    private App(){
        this.factory = new DBRepositoriesFactory();
        IStudentRepository repo = factory.getStudentRepository();
        //IStudentRepository repo = new StudentRepositoryDB();
        this.studentManager = new StudentManager(repo);
    }
    public static App getInstance(){
        if(app == null){
            app = new App();
        }
        return app;
    }
}
