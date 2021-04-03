package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    //引用类型的自动注入，使用@Autowire或者@Resource
    @Resource
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int rlt = studentDao.insertStudent(student);
        return rlt;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> studentsList = studentDao.selectStudents();
        return studentsList;
    }
}
