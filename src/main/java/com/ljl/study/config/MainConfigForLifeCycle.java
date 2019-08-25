package com.ljl.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ljl.study.bean.Car;
import com.ljl.study.bean.Cat;
import com.ljl.study.bean.Color;
import com.ljl.study.bean.ColorFactoryBean;
import com.ljl.study.bean.Dog;
import com.ljl.study.bean.MyBeanWithPostProcessor;
import com.ljl.study.bean.Person;
import com.ljl.study.condition.LinuxCondition;
import com.ljl.study.condition.WindowCondition;
import com.ljl.study.importBeanDefinitionRegistrar.MyImportBeanDefinitionRegistrar;
import com.ljl.study.importSelector.MyImportSelector;


@Configuration
public class MainConfigForLifeCycle {

    @Bean(initMethod="init",destroyMethod="destroy")
    public Car car() {
        return new Car();
    }
    
    @Bean
    public Cat cat(){
        return new Cat();
    }
    
    @Bean
    public Dog dog(){
        return new Dog();
    }
    
    @Bean
    public MyBeanWithPostProcessor myBeanWithPostProcessor(){
        return new MyBeanWithPostProcessor();
    }

}
