package com.example.beetlsql.comtroller;

import com.example.beetlsql.pojo.User;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/3
 * \* Time: 19:57
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/sqlManager/users")
public class UserControllerForSQLManager {

    //自动注入即可
    @Autowired
    private SQLManager sqlManager;

    /*
     * @Author Gabriel
     * @Description 根据主键查找记录
     * @Date 2018/10/16
     * @Param [id] 主键
     * @Return void
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User selectUserById(@PathVariable("id")int id){
        //如果没有查到数据则抛出异常
        //return sqlManager.unique(User.class,id);
        //如果没有查到数据则返回null
        return sqlManager.single(User.class,id);
    }

    /*
     * @Author Gabriel
     * @Description 查询所有
     * @Date 2018/10/16
     * @Param []
     * @Return java.util.List<com.priv.gabriel.entity.User>*/
    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public List<User> getUsers(){
        //获取所有数据
        //return sqlManager.all(User.class);
        //查询该表的总数
        //return sqlManager.allCount(User.class);
        //获取所有数据 分页方式
        return sqlManager.all(User.class,1,2);
    }

    /*
     * @Author Gabriel
     * @Description 单表条件查询
     * @Date 2018/10/16
     * @Param []
     * @Return void*/
    public void singletonTableQuery(){
        //通过sqlManager.query()可以在后面追加各种条件
        sqlManager.query(User.class).andLike("username","admin").orderBy("age").select();
    }

    /*
     * @Author Gabriel
     * @Description 新增数据
     * @Date 2018/10/16
     * @Param [user]
     * @Return void*/
    @RequestMapping(value = {"","/"},method = RequestMethod.POST)
    public void addUser(User user){
        //添加数据到对应表中
        //sqlManager.insert(User.class,user);
        //添加数据到对应表中，并返回自增id
        sqlManager.insertTemplate(user,true);
        System.out.println(user.getId());
        System.out.println("新增成功");
    }

    /*
     * @Author Gabriel
     * @Description 根据主键修改
     * @Date 2018/10/16
     * @Param [user]
     * @Return java.lang.String*/
    @RequestMapping(value = {"","/"},method = RequestMethod.PUT)
    public String updateById(User user){
        //根据id修改，所有值都参与更新
        //sqlManager.updateById(user);
        //根据id修改,属性为null的不会更新
        if(sqlManager.updateTemplateById(user)>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    /*
     * @Author Gabriel
     * @Description 删除记录
     * @Date 2018/10/16
     * @Param [id]
     * @Return java.lang.String*/
    @RequestMapping(value = "/id",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int id){
        if(sqlManager.deleteById(User.class,id) >0 ){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }




}
