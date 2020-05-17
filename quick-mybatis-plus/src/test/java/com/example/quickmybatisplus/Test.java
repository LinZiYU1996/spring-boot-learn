package com.example.quickmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.quickmybatisplus.entity.MyUser;
import com.example.quickmybatisplus.mapper.MyUserMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/15
 * \* Time: 11:28
 * \* Description:
 * \
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {


    @Autowired
    MyUserMapper myUserMapper;


    private MyUser createFactory() {

        String name= RandomStringUtils.randomAlphanumeric(7);

        String password = RandomStringUtils.randomAlphanumeric(15);

        return new MyUser(name, password, new Date().toString());

    }

    @org.junit.Test
    public void insert(){

        for (int i = 0; i < 30; i++) {
            myUserMapper.insert(createFactory());
        }

    }

    @org.junit.Test
    public void aInsert() {

        MyUser myUser = createFactory();
        assertThat(myUserMapper.insert(myUser)).isGreaterThan(0);
        // 成功直接拿会写的 ID
        assertThat(myUser.getId()).isNotNull();
    }


    @org.junit.Test
    public void bDelete() {
        assertThat(myUserMapper.deleteById(3L)).isGreaterThan(0);
        assertThat(myUserMapper.delete(new QueryWrapper<MyUser>()
                .lambda().eq(MyUser::getName, "1B6J0qt"))).isGreaterThan(0);
    }

//    @org.junit.Test
//    public void cUpdate() {
//        assertThat(myUserMapper.updateById(new MyUser().setId(10))).isGreaterThan(0);
//        assertThat(
//                myUserMapper.update(
//                        new MyUser().setName("mp"),
//                        Wrappers.<MyUser>lambdaUpdate()
//                                .set(MyUser::getAge, 3)
//                                .eq(MyUser::getId, 2)
//                )
//        ).isGreaterThan(0);
//        MyUser user = myUserMapper.selectById(2);
//        assertThat(user.getAge()).isEqualTo(3);
//        assertThat(user.getName()).isEqualTo("mp");
//
//    }

    @org.junit.Test
    public void orderBy() {
        List<MyUser> users = myUserMapper.selectList(Wrappers.<MyUser>query().orderByAsc("name"));
        assertThat(users).isNotEmpty();
    }


    @org.junit.Test
    public void selectMaps() {
        List<Map<String, Object>> mapList = myUserMapper.selectMaps(Wrappers.<MyUser>query().orderByAsc("name"));
        assertThat(mapList).isNotEmpty();
        assertThat(mapList.get(0)).isNotEmpty();
        System.out.println(mapList.get(0));
        /*
        {birthday=Sat May 16 15:21:45 CST 2020, name=2LwSPP4, id=23, pwd=ANOORZUSFKeDGRw}

         */
    }

    @org.junit.Test
    public void selectMapsPage() {
        IPage<Map<String, Object>> page = myUserMapper.selectMapsPage(new Page<>(1, 5), Wrappers.<MyUser>query().orderByAsc("name"));
        assertThat(page).isNotNull();
        assertThat(page.getRecords()).isNotEmpty();
        assertThat(page.getRecords().get(0)).isNotEmpty();
        System.out.println(page.getRecords().get(0));
        /*
        {birthday=Sat May 16 15:21:45 CST 2020, name=2LwSPP4, id=23, pwd=ANOORZUSFKeDGRw}

         */
    }

    @org.junit.Test
    public void orderByLambda() {
        List<MyUser> users = myUserMapper.selectList(Wrappers.<MyUser>lambdaQuery().orderByAsc(MyUser::getPwd));
        assertThat(users).isNotEmpty();
    }

    @org.junit.Test
    public void testSelectMaxId() {
        QueryWrapper<MyUser> wrapper = new QueryWrapper<>();
        wrapper.select("max(id) as id");
        MyUser user = myUserMapper.selectOne(wrapper);
        System.out.println("maxId=" + user.getId());
        /*
        maxId=33


         */
        List<MyUser> users = myUserMapper.selectList(Wrappers.<MyUser>lambdaQuery().orderByDesc(MyUser::getId));
        Assert.assertEquals(user.getId().longValue(), users.get(0).getId().longValue());
    }

    @org.junit.Test
    public void testGroup() {
        QueryWrapper<MyUser> wrapper = new QueryWrapper<>();
        wrapper.select("age, count(*)")
                .groupBy("age");
        List<Map<String, Object>> maplist = myUserMapper.selectMaps(wrapper);
        for (Map<String, Object> mp : maplist) {
            System.out.println(mp);
        }
        /**
         * lambdaQueryWrapper groupBy orderBy
         */
//        LambdaQueryWrapper<MyUser> lambdaQueryWrapper = new QueryWrapper<MyUser>().lambda()
//                .select(MyUser::getAge)
//                .groupBy(MyUser::getAge)
//                .orderByAsc(MyUser::getAge);
//        for (MyUser user : mapper.selectList(lambdaQueryWrapper)) {
//            System.out.println(user);
        }




}
