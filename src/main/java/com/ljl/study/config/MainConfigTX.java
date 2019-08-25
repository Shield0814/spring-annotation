package com.ljl.study.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ljl.study.bean.TbUser;
import com.ljl.study.repository.TbUserDao;
import com.ljl.study.service.TbUserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableTransactionManagement
@ComponentScan(basePackages={"com.ljl.study.service","com.ljl.study.repository"})
//@Import(value={TbUser.class,TbUserDao.class,TbUserService.class})
@PropertySource("classpath:mysql.properties")
@Configuration
public class MainConfigTX {
    
    @Bean
    public DataSource dataSource(){
        
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?allowMultiQueries=true");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    
    @Autowired
    @Bean
    public DataSourceTransactionManager tansactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
    
    @Autowired
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
    
}
