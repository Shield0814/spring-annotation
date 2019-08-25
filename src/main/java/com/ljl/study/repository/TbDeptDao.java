package com.ljl.study.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TbDeptDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(String dname){
        String sql = "insert into tb_dept(dname) values(?)";
        return jdbcTemplate.update(sql, dname);
    }
    
}
