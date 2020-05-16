package com.example.springbootmybatisplus;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.springbootmybatisplus.entity.User;
import com.example.springbootmybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * 新增数据
     */
    @Test
    public void testAdd() throws Exception{
        User entity = new User();
        entity.setUsername("admin");
        entity.setPassword("123456");
        entity.setNickName("管理员");
        entity.insert();
    }

    /**
     * 更新数据
     */
    @Test
    public void testUpdate() throws Exception{
        User entity = new User();
        entity.setId(1);
        entity.setUsername("test");
        entity.setPassword("123456");
        entity.setNickName("测试号");
        entity.updateById();
    }

    /**
     * 删除数据
     */
    @Test
    public void testDelete() throws Exception{
        User entity = new User();
        entity.deleteById(1);
    }


    /**
     * 查询指定id数据
     */
    @Test
    public void testSelectById() throws Exception{
        User entity = new User();
        User user = entity.selectById(1);
        System.out.println(user);
    }

    /**
     * 查询所有数据
     */
    @Test
    public void testSelectAll() throws Exception{
        User entity = new User();
        List list = entity.selectList(null);
        System.out.println(list);
    }

//    /**
//     * 查询所有数据 - 分页
//     */
//    @Test
//    public void testSelectAllPage() throws Exception{
//        User entity = new User();
//        Page<User> page = entity.selectPage(new Page<User>(1, 10), null);
//        System.out.println(page);
//    }




}
