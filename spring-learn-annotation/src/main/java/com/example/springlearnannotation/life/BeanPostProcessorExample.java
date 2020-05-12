package com.example.springlearnannotation.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/5/10
 * \* Time: 9:20
 * \* Description:
 * \
 */
public class BeanPostProcessorExample implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" BeanPostProcessor  "
        + "postProcessBeforeInitialization 方法 参数"+
                bean.getClass().getSimpleName()
        + "  " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor "
        + "postProcessBeforeInitialization 方法 参数"
        + bean.getClass().getSimpleName()+"  " + beanName);
        return bean;
    }
}
