package com.example.springlearnannotation.pojo.definition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/9
 * \* Time: 16:26
 * \* Description:
 * \
 */

@Component
public class BusinessPerson implements Person, BeanNameAware
, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {


    private Animal animal = null;

    public BusinessPerson(@Autowired @Qualifier("dog") Animal animal) {

        this.animal = animal;
    }

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("{ "+
                this.getClass().getSimpleName()
        +"}  BeanFactoryAware   setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {

        System.out.println("{ " +
                this.getClass().getSimpleName()+"} BeanNameAware  setBeanName");
    }

    @Override
    public void destroy() throws Exception {

        System.out.println("{  "
        + this.getClass().getSimpleName()
        + "} DisposableBean  destroy  ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("{ " + this.getClass().getSimpleName()
        +"} InitializingBean afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("{ "+this.getClass().getSimpleName()
        +"}  ApplicationContextAware   setApplicationContext");
    }

    @PostConstruct
    public void init() {
        System.out.println("{  "+
                this.getClass().getSimpleName()
        + "} 注解 PostConstruct 定义的初始化方法");
    }


    @PreDestroy
    public void destroy1() {
        System.out.println("{  "
        +this.getClass().getSimpleName()
        +"} 自定义PreDestroy");
    }
}
