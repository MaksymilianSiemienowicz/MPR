package com.example.demo.data;

import data.Student;
import data.StudentRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    @Test
    void givenEmptyStudentsListTest() {
        List<Student> students = Collections.emptyList();
        var repository = new StudentRepository();
        repository.setStudents(students);

        var index = repository.findByMaxIndex();

        assertEquals(index, 0L);
    }
}
