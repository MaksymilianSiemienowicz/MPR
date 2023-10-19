package com.example.demo.service;

import data.Student;
import data.StudentRepository;
import data.StudentUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import service.StudentService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepo;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp(){
        when(studentRepo.findByMaxIndex()).thenReturn(5L);
    }
    @Test
    void givenStudentWithUnitGdanskWhenCreateStudentThenStudentWasSavedWithValidData(){
        var student = new Student(UUID.randomUUID(), "Maksiu", StudentUnit.GDANSK, null);


        var savedStudent = studentService.createStudent(student);

        assertEquals(student.id(), savedStudent.id());
        assertEquals(student.name(), savedStudent.name());
        assertEquals(student.unit(), savedStudent.unit());
        assertEquals(25L, savedStudent.index());
        verify(studentRepo, times(1)).findByMaxIndex();
    }

    @Test
    void givenStudentWithUnitWarsawWhenCreateStudentThenStudentWasSavedWithValidData(){
        var student = new Student(UUID.randomUUID(), "Maksiu", StudentUnit.WARSZAWA, null);
        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);

        var savedStudent = studentService.createStudent(student);

        assertEquals(student.id(), savedStudent.id());
        assertEquals(student.name(), savedStudent.name());
        assertEquals(student.unit(), savedStudent.unit());
        assertEquals(50L, savedStudent.index());
        verify(studentRepo, times(1)).findByMaxIndex();
        verify(studentRepo, times(1)).createStudent(captor.capture());
        var studentArg = captor.getValue();
        assertEquals(student.id(), studentArg.id());
        assertEquals(student.name(), studentArg.name());
        assertEquals(student.unit(), studentArg.unit());
        assertEquals(50L, studentArg.index());
    }
}