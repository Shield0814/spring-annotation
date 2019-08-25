package com.ljl.study.bean;

public class TbUser {

    private int id;
    
    private String name;

    
    public TbUser() {
        super();
    }

    public TbUser(String name) {
        super();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
