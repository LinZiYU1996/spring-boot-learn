package com.example.mybatisplus;

import com.example.mybatisplus.entity.MyUser;
import com.example.mybatisplus.mapper.MyUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/18
 * \* Time: 16:15
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class MyUserMapperTest {


    @Autowired
    MyUserMapper myUserMapper;

    Random random = new Random();
    private String[] country =
            {
              "china","usa","uk","japan","rusain"
            };

    private String[] address =
            {
                    "beijing","sahnghai","guangzhou","chendou","chongqin"
            };

    private String[] sex =
            {
              "男","女"
            };


    private String generateCountry() {
        return country[random.nextInt(country.length)];
    }
    private String generateSex() {
        return sex[random.nextInt(sex.length)];
    }

    private String generateAddress() {
        return address[random.nextInt(address.length)];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
//            System.out.println(new MyUserMapperTest().generateCountry());
            System.out.println(new MyUserMapperTest().generator().toString());

        }

    }
    private MyUser generator() {
        String name= RandomStringUtils.randomAlphanumeric(7);
        MyUser myUser = new MyUser();
        myUser.setName(name);
        myUser.setAddress(generateAddress());
        myUser.setBirthday(randomLocalDateTime(1,1000));
        myUser.setCountry(generateCountry());
        myUser.setSex(generateSex());
        return myUser;
    }

    @Test
    public void test_insert() {


        for (int i = 0; i < 25; i++) {

            myUserMapper.insert(generator());
        }



    }
















    /**
     * 取范围日期的随机日期时间,不含边界
     * @param startDay
     * @param endDay
     * @return
     */
    private String randomLocalDateTime(int startDay, int endDay){

        int plusMinus = 1;
        if(startDay < 0 && endDay > 0){
            plusMinus = Math.random()>0.5?1:-1;
            if(plusMinus>0){
                startDay = 0;
            }else{
                endDay = Math.abs(startDay);
                startDay = 0;
            }
        }else if(startDay < 0 && endDay < 0){
            plusMinus = -1;

            //两个数交换
            startDay = startDay + endDay;
            endDay  = startDay - endDay;
            startDay = startDay -endDay;

            //取绝对值
            startDay = Math.abs(startDay);
            endDay = Math.abs(endDay);

        }

        LocalDate day = LocalDate.now().plusDays(plusMinus * RandomUtils.nextInt(startDay,endDay));
        int hour = RandomUtils.nextInt(1,24);
        int minute = RandomUtils.nextInt(0,60);
        int second = RandomUtils.nextInt(0,60);
        LocalTime time = LocalTime.of(hour, minute, second);
        return LocalDateTime.of(day, time).toString();
    }



}
