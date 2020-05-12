package com.example.springbeanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBeanLifecycleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanLifecycleApplication.class, args);
    }

}


//2020-05-10 16:46:34.976  INFO 10844 --- [           main] o.s.c.a.ConfigurationClassEnhancer       : @Bean method BeanConfig.user is non-static and returns an object assignable to Spring's BeanFactoryPostProcessor interface. This will result in a failure to process annotations such as @Autowired, @Resource and @PostConstruct within the method's declaring @Configuration class. Add the 'static' modifier to this method to avoid these container lifecycle issues; see @Bean javadoc for complete details.
//构造方法...
//[BeanNameAware]接口调用 setBeanName(String name)。。。
//[BeanFactoryAware]接口调用 setBeanFactory(BeanFactory beanFactory)。。。
//[InitializingBean]接口调用 afterPropertiesSet()。。。
//自定义initMethod 。。。
//[BeanFactoryPostProcessor]工厂后处理器接口postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
//[BeanPostProcessor]postProcessBeforeInitialization(springBeanLifecycleApplication, springBeanLifecycleApplication ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(springBeanLifecycleApplication, springBeanLifecycleApplication) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.AutoConfigurationPackages, org.springframework.boot.autoconfigure.AutoConfigurationPackages ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.AutoConfigurationPackages, org.springframework.boot.autoconfigure.AutoConfigurationPackages) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration, org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration, org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration, org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration, org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(objectNamingStrategy, objectNamingStrategy ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(objectNamingStrategy, objectNamingStrategy) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(mbeanServer, mbeanServer ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(mbeanServer, mbeanServer) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(mbeanExporter, mbeanExporter ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(mbeanExporter, mbeanExporter) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration, org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration, org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(springApplicationAdminRegistrar, springApplicationAdminRegistrar ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(springApplicationAdminRegistrar, springApplicationAdminRegistrar) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration, org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration, org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.aop.AopAutoConfiguration, org.springframework.boot.autoconfigure.aop.AopAutoConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.aop.AopAutoConfiguration, org.springframework.boot.autoconfigure.aop.AopAutoConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration, org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration, org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata, org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata, org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties, spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties, spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration, org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration, org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration, org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration, org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties, spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties, spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(taskExecutorBuilder, taskExecutorBuilder ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(taskExecutorBuilder, taskExecutorBuilder) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration, org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration, org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties, spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties, spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties) 对属性进行更改
//[BeanPostProcessor]postProcessBeforeInitialization(taskSchedulerBuilder, taskSchedulerBuilder ) 对属性进行更改
//[BeanPostProcessor]postProcessAfterInitialization(taskSchedulerBuilder, taskSchedulerBuilder) 对属性进行更改
//2020-05-10 16:46:35.092  INFO 10844 --- [           main] c.e.s.SpringBeanLifecycleApplication     : Started SpringBeanLifecycleApplication in 0.797 seconds (JVM running for 2.251)
//[DisposableBean]接口调用 destroy()。。。
//自定义destroyMethod 。。。



