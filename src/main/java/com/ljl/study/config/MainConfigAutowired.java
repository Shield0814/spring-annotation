package com.ljl.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ljl.study.bean.Boss;
import com.ljl.study.bean.Car;

@Configuration
public class MainConfigAutowired {

    @Autowired 
    @Bean
    public Boss boss(Car car){
        Boss boss = new Boss();
        boss.setCar(car);
        return boss;
    }
    
    @Bean
    public Car car(){
        return new Car();
    }
   
}
