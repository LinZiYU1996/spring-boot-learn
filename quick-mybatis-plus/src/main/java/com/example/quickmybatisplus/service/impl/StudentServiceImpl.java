package com.example.quickmybatisplus.service.impl;

import com.example.quickmybatisplus.entity.Student;
import com.example.quickmybatisplus.mapper.StudentMapper;
import com.example.quickmybatisplus.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BaoZhou
 * @since 2020-05-15
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
