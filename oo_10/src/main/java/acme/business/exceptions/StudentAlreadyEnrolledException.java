package acme.business.exceptions;

public class StudentAlreadyEnrolledException extends Exception {
    private String name;
    public StudentAlreadyEnrolledException(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
