package data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {


    private final List<Student> students = new ArrayList<>();

    public void createStudent(Student student) {

        students.add(student);

    }
}
