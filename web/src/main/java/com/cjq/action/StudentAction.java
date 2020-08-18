package com.cjq.action;

import com.cjq.bean.Student;
import com.cjq.service.feign.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentAction {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getAllStudent")
    public String getAllStudent() {
        return studentService.getAllStudent();
    }

    @RequestMapping("/getStudentById")
    public String getStudentById(Integer id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping("/errorMessage")
    public String errorMessage(Integer id) {
        try {
            return studentService.errorMessage(id);
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping("/saveStudent")
    public String saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
