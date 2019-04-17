package az.client.parser;

import az.client.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    static JSONParser parser = new JSONParser();

    static {
        parser = new JSONParser();
    }

    public static Student parseStudentJson(String json) throws ParseException, IOException {
//        JSONObject jsonObject = (JSONObject) parser.parse(json);
//        String id = (String) jsonObject.get("id");
//        String name = (String) jsonObject.get("name");
//        String surname = (String) jsonObject.get("surname");
//
//        Student student = new Student();
//        student.setId(Integer.parseInt(id));
//        student.setName(name);;
//        student.setSurname(surname);

        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(json,Student.class);

        return student;
    }

    public static List<Student> parseStudentListJson(String json) throws ParseException, IOException {
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        JSONArray jsonArray = (JSONArray) jsonObject.get("student");

        List<Student> students = new ArrayList<>();

        for (int i = 0; i<jsonArray.size();i++){
            JSONObject  studentObject = (JSONObject) jsonArray.get(i);
            students.add(JsonParser.parseStudentJson(studentObject.toJSONString()));
        }
        return students;
    }
}
