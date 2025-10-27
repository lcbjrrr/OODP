package acme;

public class DBRepositoriesFactory implements RepositoriesAbstractFactory{
    public IStudentRepository getStudentRepository() {
        return new StudentRepositoryDB();
    }
}
