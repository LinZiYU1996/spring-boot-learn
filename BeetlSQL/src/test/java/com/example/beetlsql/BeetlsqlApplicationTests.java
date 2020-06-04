package com.example.beetlsql;

import com.example.beetlsql.dao.AccountDao;
import com.example.beetlsql.pojo.Account;
import com.example.beetlsql.pojo.User;
import com.example.beetlsql.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeetlsqlApplicationTests {
    @Autowired
    private UserRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testBeetlTest() throws JsonProcessingException {
        //        List<Account> resultList = accountDao.all();


        User user = new User();
        user.setAge(11);
        repository.insert(user);

//        Account account = accountDao.queryAccountByName("李四");
//
//        ObjectMapper mapper = new ObjectMapper();
//        String str = mapper.writeValueAsString(account);
//        System.out.println("queryAccountByName:" + str);
    }


}
