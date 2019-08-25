package com.ljl.study.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ljl.study.bean.TbUser;

@Repository
public class TbUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(TbUser user){
        String sql = "insert into tb_user(name) values(?)";
        return jdbcTemplate.update(sql, user.getName());
    }
    
    

}
