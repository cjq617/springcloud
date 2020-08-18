package com.cjq.service;

import com.cjq.bean.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public String getAllStudent() {
        return "cjq,wqx";
    }

    @Override
    public String saveStudent(Student student) {
        return "F";
    }

    @Override
    public String queryStudentById(Integer id) {
        return "cjq";
    }

    @Override
    public String errorMessage(Integer id) {
        try {
            int a = 1 / 0;
            return "studen";
        }catch (Exception e) {
            e.printStackTrace();
//            return e.getMessage();
            throw e;
        }
    }
}
