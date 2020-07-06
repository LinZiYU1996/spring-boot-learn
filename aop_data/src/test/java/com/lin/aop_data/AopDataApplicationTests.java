package com.lin.aop_data;

import com.lin.aop_data.entity.Adddress;
import com.lin.aop_data.mapper.AdddressMapper;
import com.lin.aop_data.service.IAdddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AopDataApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    AdddressMapper adddressMapper;

    @Autowired
    private IAdddressService service;
    @Test
    public void t1() {
        Adddress adddress = new Adddress("china",55);
        adddress.setId(1);
        adddressMapper.insert(adddress);

    }


    @Test
    public void t2() {
        List<Adddress> adddresses = service.getAll();


    }

}
