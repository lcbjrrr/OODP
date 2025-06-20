package acme.integration;

import acme.business.Student;

import java.util.List;

public interface ExternalPartnerAPI {
    public List<Student> getStudents();
}
