package com.ljl.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ljl.study.repository.TbDeptDao;

@Service
public class TbDeptService {

    @Autowired
    private TbDeptDao dao;
    
    @Transactional(propagation=Propagation.MANDATORY)
    public int save(String dname){
        return dao.insert(dname);
    }

}
