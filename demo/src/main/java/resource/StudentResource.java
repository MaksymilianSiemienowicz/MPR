package resource;

import data.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

@RestController
@RequestMapping(path="/students")
@RequiredArgsConstructor
public class StudentResource {

    private final StudentService studentService;

    @PostMapping
    public void createStudent(@RequestBody Student student){

        studentService.createStudent(student);

    }

    @GetMapping("/{id}")
    public Student student getStudentById(){

    }
}
