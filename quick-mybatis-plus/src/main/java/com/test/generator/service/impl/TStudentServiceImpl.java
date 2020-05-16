package com.test.generator.service.impl;

import com.test.generator.entity.TStudent;
import com.test.generator.mapper.TStudentMapper;
import com.test.generator.service.ITStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lin
 * @since 2020-05-15
 */
@Service
public class TStudentServiceImpl extends ServiceImpl<TStudentMapper, TStudent> implements ITStudentService {

}
