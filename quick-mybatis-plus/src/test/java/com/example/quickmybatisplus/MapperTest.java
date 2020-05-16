package com.example.quickmybatisplus;

import com.example.quickmybatisplus.entity.Student;
import com.example.quickmybatisplus.entity.User;
import com.example.quickmybatisplus.mapper.StudentMapper;
import com.example.quickmybatisplus.service.impl.StudentServiceImpl;
import com.sun.corba.se.spi.orb.ParserImplBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/15
 * \* Time: 10:09
 * \* Description:
 * \
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTest {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentServiceImpl studentService;


    @Test
    public void insert(){
        Student student = new Student();
        student.setName("haha1111");
        studentMapper.insert(student);
    }

    @Test
    public void select(){

        Student student = studentMapper.selectById(1);

        System.out.println(student);
    }


}
