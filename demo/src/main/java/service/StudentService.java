package service;


import data.Student;
import data.StudentRepository;
import data.StudentUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student createStudent(Student student) {
        var index = createIndex(student.unit());
        var studentToSave = new Student(student.id(), student.name(), student.unit(), index);
        studentRepo.createStudent(studentToSave);
        return studentToSave;
    }

    public Optional<Student> getStudentById(UUID id) {
        return studentRepo.getStudentById(id);
    }

    public void deleteByName(String name) {
        studentRepo.deleteByName(name);
    }

    private Long createIndex(StudentUnit unit){
        if(StudentUnit.GDANSK.equals(unit)){
            return 5 * studentRepo.findByMaxIndex();
        } else {
            return 10* studentRepo.findByMaxIndex();
        }
    }
}
