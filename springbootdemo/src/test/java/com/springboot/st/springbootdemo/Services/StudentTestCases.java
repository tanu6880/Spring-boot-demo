package com.springboot.st.springbootdemo.Services;

import com.springboot.st.springbootdemo.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

class StudentTestCases {

    StudentServices studentServices = Mockito.mock(StudentServices.class);

    Student s1 = new Student(studentServices);

    @Test
    void TestAverageMarks()
    {
        Mockito.when(studentServices.getTotalMarks()).thenReturn(10);
        Mockito.when(studentServices.getTotalStudents()).thenReturn(500);
        assertEquals(50,studentServices.getTotalStudents()/studentServices.getTotalMarks());
    }

}