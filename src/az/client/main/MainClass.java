package az.client.main;

import az.client.model.Student;
import az.client.parser.JsonParser;
import az.client.services.ServiceClient;

import java.util.List;

public class MainClass {
    public static void main(String[] args) throws Exception {
        int id = 152;
        String url = "http://localhost:8085/services/student/getStudentList";
        String response = ServiceClient.sendGet(url);
//        Student student = JsonParser.parseStudentJson(response);
//        System.out.println("Student: " + student);

        List<Student> students = JsonParser.parseStudentListJson(response);
        for (Student student : students){
            System.out.println(student);
        }


//        String url = "http://localhost:8085/services/student/addStudent";
//        String requestData = "{\n" +
//                "      \"id\": \"1\",\n" +
//                "      \"name\": \"Natiq\",\n" +
//                "      \"surname\": \"Natiq\"\n" +
//                "    }";
//        String response = ServiceClient.sendPost(url,requestData);
//        System.out.println(response);
    }

}
