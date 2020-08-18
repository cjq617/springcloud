package com.cjq.service.feign;

import com.cjq.bean.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/*@Slf4j*/
@Component
public class StudentServiceFallbackFactory implements FallbackFactory<StudentService> {

    @Override
    public StudentService create(Throwable throwable) {

        if(throwable == null) {
            return null;
        }
        final String msg = throwable.getMessage();
        System.out.println("exception:" + msg);
        return new StudentService() {
            @Override
            public String getAllStudent() {
                System.out.println("exception=====getAllStudent==========" + msg);
                return msg;
            }

            @Override
            public String saveStudent(Student student) {
                System.out.println("exception=====saveStudent==========" + msg);
                return msg;
            }

            @Override
            public String getStudentById(Integer id) {
                System.out.println("exception=====getStudentById==========" + msg);
                return msg;
            }

            @Override
            public String errorMessage(Integer id) {
                System.out.println("exception=====errorMessage==========" + msg);
                return msg;
            }
        };
    }
}
