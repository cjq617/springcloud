package com.cjq.action;

import com.cjq.bean.Student;
import com.cjq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentAction implements StudentService {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/feign/student/getAllStudent")
    @Override
    public String getAllStudent() {
        return studentService.getAllStudent();
    }

    @RequestMapping("/feign/student/saveStudent")
    @Override
    public String saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @RequestMapping("/feign/student/getStudentById")
    @Override
    public String queryStudentById(@RequestParam("id") Integer id) {
        return studentService.queryStudentById(id);
    }

    @RequestMapping("/feign/student/errorMessage")
    @Override
    public String errorMessage(@RequestParam("id") Integer id) {
        return  studentService.errorMessage(id);
    }
}
