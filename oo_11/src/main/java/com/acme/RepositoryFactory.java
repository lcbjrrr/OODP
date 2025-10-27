package com.acme;

public class RepositoryFactory {
    public static IStudentRepository getStudentRepository(int repoType) {
        if (repoType==0){
            return new StudentRepositoryDB();
        }else{return null;}
    }
}
