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

import com.ljl.study.bean.Color;
import com.ljl.study.bean.ColorFactoryBean;
import com.ljl.study.bean.Person;
import com.ljl.study.condition.LinuxCondition;
import com.ljl.study.condition.WindowCondition;
import com.ljl.study.importBeanDefinitionRegistrar.MyImportBeanDefinitionRegistrar;
import com.ljl.study.importSelector.MyImportSelector;

@Import(value = { MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
@ComponentScan(basePackages = { "com.ljl.study" }, useDefaultFilters = true, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = { Controller.class, ControllerAdvice.class }) })
@Configuration
public class MainConfig {
    
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
    
    @Bean
    public Person person() {
        return new Person();
    }
    
    @Conditional(value = WindowCondition.class)
    @Bean
    public Person bill(){
        return new Person("Bill Gates", 65);
    }
    
    @Conditional(value = LinuxCondition.class)
    @Bean
    public Person linus(){
        return new Person("Linux", 48);
    }

}
