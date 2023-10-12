package resource;

import data.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.*;

@RestController
@RequestMapping(path="/students")
@RequiredArgsConstructor
public class StudentResource {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){

        studentService.createStudent(student);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable UUID id) {
        return studentService.getStudentById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping
    public void deleteByName(String name){
        studentService.deleteByName(name);
    }
}
