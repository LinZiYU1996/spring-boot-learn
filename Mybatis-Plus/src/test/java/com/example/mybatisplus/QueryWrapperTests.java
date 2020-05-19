package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.entity.MyUser;
import com.example.mybatisplus.mapper.MyUserMapper;
import com.example.mybatisplus.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/18
 * \* Time: 17:06
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
//SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
@SpringBootTest
@Slf4j
public class QueryWrapperTests {


    @Autowired
    private MyUserMapper myUserMapper;

    /**
     * <p>
     * 根据根据 entity 条件，删除记录,QueryWrapper实体对象封装操作类（可以为 null）
     * 下方获取到queryWrapper后删除的查询条件为name字段为null的and年龄大于等于12的and email字段不为null的
     * 同理写法条件添加的方式就不做过多介绍了。
     * </p>
     */
    @Test
    public void delete() {
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .ge("sex", "男");
        int delete = myUserMapper.delete(queryWrapper);
        System.out.println("delete return count = " + delete);
    }


    /**
     * <p>
     * 根据 entity 条件，查询一条记录,
     * 这里和上方删除构造条件一样，只是seletOne返回的是一条实体记录，当出现多条时会报错
     * </p>
     */
    @Test
    public void selectOne() {
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("country", "china");

        MyUser user = myUserMapper.selectOne(queryWrapper);
        System.out.println(user);
        /*
        MyUser{id=3, name=QtmH3oF, birthday=2023-01-03T23:20:30, sex=女, address=sahnghai, country=china}

         */
    }

    /**
     * <p>
     * 根据 Wrapper 条件，查询总记录数
     * </p>
     *
     * @param queryWrapper 实体对象
     */
    @Test
    public void selectCount() {
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("address", "sahnghai");

        Integer count = myUserMapper.selectCount(queryWrapper);
        System.out.println(count);
        /*
        2
         */
    }

    /**
     * <p>
     * 根据 entity 条件，查询全部记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）为null查询全部
     */
    @Test
    public void selectList() {
        List<MyUser> list = myUserMapper.selectList(null);

        System.out.println(list);

        /*
        [
        MyUser{id=3, name=QtmH3oF, birthday=2023-01-03T23:20:30, sex=女, address=sahnghai, country=china},
        MyUser{id=4, name=YOkInf1, birthday=2022-01-02T15:22:43, sex=女, address=guangzhou, country=usa},
        MyUser{id=6, name=DwpjOY1, birthday=2021-11-05T05:33:28, sex=女, address=sahnghai, country=rusain},
        MyUser{id=8, name=ZdFhnaL, birthday=2021-11-19T18:28, sex=女, address=guangzhou, country=uk}
        ]

         */
    }

    /*
    例1: allEq({id:1,name:"老王",age:null})--->id = 1 and name = '老王' and age is null
    例2: allEq({id:1,name:"老王",age:null}, false)--->id = 1 and name = '老王'
     */
    @Test
    public void allEq() {

        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        HashMap<String,String> maps = new HashMap<>();
        maps.put("sex","男");
        queryWrapper
                .allEq(maps);
        List<MyUser> list = myUserMapper.selectList(queryWrapper);

        System.out.println(list);

/*
[MyUser{id=12, name=xxxxxxx, birthday=2021-01-25T06:42:44, sex=男, address=chendou, country=uk}, MyUser{id=13, name=xxxxxxx, birthday=2022-12-08T21:49:48, sex=男, address=chendou, country=rusain}, MyUser{id=16, name=xxxxxxx, birthday=2023-01-21T07:34:57, sex=男, address=sahnghai, country=usa}, MyUser{id=19, name=xxxxxxx, birthday=2021-02-01T14:20:50, sex=男, address=chendou, country=japan}, MyUser{id=22, name=xxxxxxx, birthday=2020-07-12T05:54:49, sex=男, address=sahnghai, country=uk}, MyUser{id=26, name=xxxxxxx, birthday=2020-08-18T04:53:56, sex=男, address=guangzhou, country=china}, MyUser{id=27, name=xxxxxxx, birthday=2020-05-24T09:21:17, sex=男, address=chendou, country=usa}, MyUser{id=28, name=xxxxxxx, birthday=2020-06-10T17:31:29, sex=男, address=chendou, country=usa}, MyUser{id=32, name=xxxxxxx, birthday=2021-07-04T11:17:56, sex=男, address=beijing, country=china}]

 */
    }


    @Test
    public void groupBy() {
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy("sex");

        List<MyUser> list = myUserMapper.selectList(queryWrapper);

        System.out.println(list);


    }



    /**
     * <p>
     * 根据 Wrapper 条件，查询全部记录
     * </p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Test
    public void selectMaps() {
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("sex","女")
                .eq("country","china");
        List<Map<String, Object>> maps = myUserMapper.selectMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }

        /*
        {birthday=2023-01-03T23:20:30, country=china, address=sahnghai, sex=女, name=QtmH3oF, id=3}

         */
    }


    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Test
    public void selectPage() {
        Page<MyUser> page = new Page<>(1, 5);
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();

        IPage<MyUser> userIPage = myUserMapper.selectPage(page, queryWrapper);
        System.out.println(userIPage);
        /*
        com.baomidou.mybatisplus.extension.plugins.pagination.Page@61e3cf4d

         */
    }

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity        实体对象 (set 条件值,不能为 null)
     * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
     */
    @Test
    public void update() {

        //修改值
        MyUser user = new MyUser();
        user.setName("xxxxxxx");

        //修改条件s
        UpdateWrapper<MyUser> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper
                .eq("sex", "男");

        int update = myUserMapper.update(user, userUpdateWrapper);

        System.out.println(update);
    }


    @Test
    public void getAll() {
        UpdateWrapper<MyUser> userUpdateWrapper = new UpdateWrapper<>();
        List<MyUser> list = myUserMapper.getAll(userUpdateWrapper);

        System.out.println(list);
    }
    /*

    [MyUser{id=3, name=QtmH3oF, birthday=2023-01-03T23:20:30, sex=女, address=sahnghai, country=china}, MyUser{id=4, name=YOkInf1, birthday=2022-01-02T15:22:43, sex=女, address=guangzhou, country=usa}, MyUser{id=6, name=DwpjOY1, birthday=2021-11-05T05:33:28, sex=女, address=sahnghai, country=rusain}, MyUser{id=8, name=ZdFhnaL, birthday=2021-11-19T18:28, sex=女, address=guangzhou, country=uk}, MyUser{id=11, name=x8Zi272, birthday=2020-07-28T07:12:42, sex=女, address=sahnghai, country=rusain}, MyUser{id=12, name=xxxxxxx, birthday=2021-01-25T06:42:44, sex=男, address=chendou, country=uk}, MyUser{id=13, name=xxxxxxx, birthday=2022-12-08T21:49:48, sex=男, address=chendou, country=rusain}, MyUser{id=14, name=h2Z0rTU, birthday=2021-07-19T11:53:26, sex=女, address=chendou, country=rusain}, MyUser{id=15, name=rzVMlBh, birthday=2022-02-14T17:27:38, sex=女, address=sahnghai, country=japan}, MyUser{id=16, name=xxxxxxx, birthday=2023-01-21T07:34:57, sex=男, address=sahnghai, country=usa}, MyUser{id=17, name=2iOrbX4, birthday=2021-06-16T01:35:26, sex=女, address=sahnghai, country=japan}, MyUser{id=18, name=TikrJz5, birthday=2020-06-09T08:49:44, sex=女, address=chendou, country=usa}, MyUser{id=19, name=xxxxxxx, birthday=2021-02-01T14:20:50, sex=男, address=chendou, country=japan}, MyUser{id=20, name=pxYvzb9, birthday=2021-10-17T14:18:02, sex=女, address=beijing, country=uk}, MyUser{id=21, name=QZqfWy5, birthday=2021-04-25T10:10:07, sex=女, address=chendou, country=rusain}, MyUser{id=22, name=xxxxxxx, birthday=2020-07-12T05:54:49, sex=男, address=sahnghai, country=uk}, MyUser{id=23, name=FieulS0, birthday=2023-01-31T23:15:47, sex=女, address=sahnghai, country=japan}, MyUser{id=24, name=fiEFzrT, birthday=2021-07-16T22:32:21, sex=女, address=guangzhou, country=usa}, MyUser{id=25, name=292xg7O, birthday=2021-02-09T07:03:28, sex=女, address=sahnghai, country=japan}, MyUser{id=26, name=xxxxxxx, birthday=2020-08-18T04:53:56, sex=男, address=guangzhou, country=china}, MyUser{id=27, name=xxxxxxx, birthday=2020-05-24T09:21:17, sex=男, address=chendou, country=usa}, MyUser{id=28, name=xxxxxxx, birthday=2020-06-10T17:31:29, sex=男, address=chendou, country=usa}, MyUser{id=29, name=jyOkuT9, birthday=2021-05-31T10:27:13, sex=女, address=guangzhou, country=japan}, MyUser{id=30, name=TIn1FYD, birthday=2021-10-12T07:29:11, sex=女, address=guangzhou, country=rusain}, MyUser{id=31, name=ZJDYxwo, birthday=2021-05-12T23:14:57, sex=女, address=guangzhou, country=uk}, MyUser{id=32, name=xxxxxxx, birthday=2021-07-04T11:17:56, sex=男, address=beijing, country=china}, MyUser{id=33, name=uVXTQfd, birthday=2022-02-06T04:31:12, sex=女, address=chendou, country=rusain}, MyUser{id=34, name=Zpz7M2q, birthday=2020-06-24T14:44:44, sex=女, address=chendou, country=usa}, MyUser{id=35, name=UsKilHp, birthday=2022-04-17T16:02:22, sex=女, address=sahnghai, country=usa}]

     */



}
