package com.springboot.st.springbootdemo;

import com.springboot.st.springbootdemo.Services.StudentServices;

public class Student {
    StudentServices studentServices;

    public Student(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    public int getAverageMarks()
    {
        return studentServices.getTotalMarks()/ studentServices.getTotalStudents();
    }

}
