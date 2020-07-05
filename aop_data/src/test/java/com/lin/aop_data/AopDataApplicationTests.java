package com.lin.aop_data;

import com.lin.aop_data.entity.Adddress;
import com.lin.aop_data.mapper.AdddressMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopDataApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    AdddressMapper adddressMapper;

    @Test
    public void t1() {
        Adddress adddress = new Adddress("china",55);
        adddress.setId(1);
        adddressMapper.insert(adddress);

    }


}
