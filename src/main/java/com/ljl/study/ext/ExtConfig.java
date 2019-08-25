package com.ljl.study.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ljl.study.bean.Car;

@ComponentScan("com.ljl.study.ext")
@Configuration
public class ExtConfig {
    
    @Bean
    public Car car(){
       return new Car();
    }
}
