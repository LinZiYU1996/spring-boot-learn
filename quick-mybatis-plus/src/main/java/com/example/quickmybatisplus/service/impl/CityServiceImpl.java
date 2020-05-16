package com.example.quickmybatisplus.service.impl;

import com.example.quickmybatisplus.entity.City;
import com.example.quickmybatisplus.mapper.CityMapper;
import com.example.quickmybatisplus.service.ICityService;
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
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {

}
