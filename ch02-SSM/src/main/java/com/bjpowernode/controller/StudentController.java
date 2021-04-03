package com.bjpowernode.controller;

import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService service;

    //注册学生
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        String tips = "注册失败";
        //调用service处理Student
        int nums = service.addStudent(student);

        if (nums > 0 ){
            //注册成功
            tips = "学生["+student.getName()+"]注册成功";
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("tips",tips);
        mv.setViewName("result");
        return mv;
    }

    //查询学生
    @RequestMapping("queryStudents.do")
    @ResponseBody
    public List<Student> queryStudents(){
        List<Student> studentList = service.queryStudents();
        return studentList;

    }
}
