package org.acme.data;


import org.acme.business.IStudentRepository;

public class DBRepositoriesFactory implements org.acme.business.RepositoriesAbstractFactory {
    public IStudentRepository getStudentRepository() {
        return new StudentRepositoryDB();
    }
}
