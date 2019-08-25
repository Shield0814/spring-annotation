package com.ljl.study.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.ljl.study.bean.Boss;
import com.ljl.study.bean.Car;
import com.ljl.study.bean.Cat;
import com.ljl.study.config.MainConfig;
import com.ljl.study.config.MainConfigAOP;
import com.ljl.study.config.MainConfigAutowired;
import com.ljl.study.config.MainConfigForLifeCycle;
import com.ljl.study.config.MainConfigTX;
import com.ljl.study.ext.ExtConfig;
import com.ljl.study.service.PersonService;
import com.ljl.study.service.TbUserService;

public class IOCTest {
    
    @Test
    public void testExt(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);
        Car car = context.getBean(Car.class);
        context.publishEvent(new ApplicationEvent("发布了一个evnet") {
        });
        context.close();
    }
    
    
    @Test
    public void testTx(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigTX.class);
        TbUserService userService = context.getBean(TbUserService.class);
        userService.saveUserAAndDeptA();
//        userService.save(new TbUser(UUID.randomUUID().toString().substring(0, 5)));
        
        context.close();
    }
   
    
    @Test
    public void testAOP(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAOP.class);
        PersonService personService = context.getBean(PersonService.class);
        personService.div(1, 2);
       
        context.close();
        
    }
    
    @Test
    public void testAutowired(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigAutowired.class);
        Boss boss = context.getBean(Boss.class);
        Car car = context.getBean(Car.class);
        System.out.println(boss);
        System.out.println(boss.getCar() == car);
        context.close();
    }
    
    @Test
    public void testLifeCycle(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigForLifeCycle.class);
        System.out.println("ioc 容器创建完成。。。");
        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);
        context.close();
    }
    
    @Test
    public void test03(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Object bean = context.getBean("colorFactoryBean");
        Object bean1 = context.getBean("colorFactoryBean");
        Object bean2 = context.getBean("&colorFactoryBean");
        System.out.println(bean == bean1);
        System.out.println(bean2);
    }
    
    @Test
    public void test02(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Environment environment = context.getEnvironment();
        String osName = environment.getProperty("os.name");
        System.out.println(osName);
    }
    
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
            System.out.println(name);
        }
    }
    

}
