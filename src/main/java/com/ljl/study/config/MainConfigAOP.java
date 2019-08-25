package com.ljl.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ljl.study.aspects.LogAspect;
import com.ljl.study.service.PersonService;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
    
    @Bean
    public PersonService personService(){
        return new PersonService();
    }
}
