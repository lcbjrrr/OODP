package acme.integration;

import acme.business.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FBIExternalPartnerAPI implements ExternalPartnerAPI {
    public List<Student> getStudents(){
        String API_URL = "https://api.fbi.gov/wanted/v1/list?field_offices=detroit";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                FBIWantedResponse fbiResponse = objectMapper.readValue(response.body(), FBIWantedResponse.class);
                return fbiResponse.getItems().stream()
                        .map(item -> new Student(item.getTitle(), item.getReward_max()))
                        .collect(Collectors.toList());
            } else {return Collections.emptyList();}
        } catch (IOException | InterruptedException e) {return Collections.emptyList();}



    }
    public static void main(String[] args) {
        FBIExternalPartnerAPI integration = new FBIExternalPartnerAPI();
        List<Student> students = integration.getStudents();
        if (!students.isEmpty()) {
            for (Student student : students) {
                System.out.println(student.getName()+" - "+student.getGrade());
            }
        } else {
            System.out.println("No students found or an error occurred.");
        }
    }

}
