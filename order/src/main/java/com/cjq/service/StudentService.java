package com.cjq.service;


import com.cjq.bean.Student;

public interface StudentService {

    String getAllStudent();

    String saveStudent(Student student);

    String queryStudentById(Integer id);

    String errorMessage(Integer id);
}
