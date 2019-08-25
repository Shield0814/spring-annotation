package com.ljl.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ljl.study.bean.TbUser;
import com.ljl.study.repository.TbUserDao;

@Service
public class TbUserService {

    @Autowired
    private TbUserDao dao;
    
    @Autowired
    private TbDeptService tbDeptService;
    
    
    @Transactional
    public int save(TbUser user){
        int result = dao.insert(user);
        
//        int d = 10 / 0;
        return result;
    }
    
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public int saveA(){
        return dao.insert(new TbUser("AAAA"));
    }
    
    @Transactional
    public int savaB(){
        return dao.insert(new TbUser("BBBB"));
    }
    
//    @Transactional
    public int saveUserAAndDeptA(){
        saveA();
        tbDeptService.save("AAAA");
//        int i = 1/0;
        return 0;
    }
    
}
