package com.example.elasticsearch;

import com.example.elasticsearch.entity.Customer;
import com.example.elasticsearch.repository.CustomerRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/6
 * \* Time: 11:14
 * \* Description:
 * \
 */

@SpringBootTest

public class CustomerTest {


    @Autowired
    CustomerRepository customerRepository;
    public String gen() {
        int length = 10;

        boolean useLetters = true;

        boolean useNumbers = false;

        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return generatedString;
    }

    @Test
    public void test() {

        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName(gen());
            customer.setLastName(gen());
            customerRepository.save(customer);

        }
    }
}
