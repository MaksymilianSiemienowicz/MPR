package service;


import data.Student;
import data.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void createStudent(Student student) {

        studentRepository.createStudent(student);

    }
}
