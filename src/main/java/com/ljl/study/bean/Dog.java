package com.ljl.study.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {

    public Dog() {
        System.out.println("dog constructor...");
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("dog @PreDestroy...");
    }
    
    @PostConstruct
    public void init(){
        System.out.println("dog @PostConstruct...");
    }
}
