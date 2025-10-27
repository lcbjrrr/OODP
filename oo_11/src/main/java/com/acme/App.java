package com.acme;

public class App {
    private static App app;
    private StudentManager studentManager;
    private App(int repoType){
        //IStudentRepository repo = new StudentRepositoryDB();
        IStudentRepository repo = RepositoryFactory.getStudentRepository(repoType);
        this.studentManager = new StudentManager(repo);
    }
    public static App getIntance(int repoType) {
        if  (app == null) {
            app = new App(repoType);
        }
        return app;
    }
//    private App(int repoType){
//        IStudentRepository repo = new StudentRepositoryDB();
//        this.studentManager = new StudentManager(repo);
//    }

}
