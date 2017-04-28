package com.liang.mvn.test;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

/**
 * Created by liang on 2017/4/26.
 */
public class TestSpring {
    @Test
    public void testReadConfig() throws IOException
    {
        System.out.println(this.getClass().getResource(""));
        System.out.println(this.getClass().getResource("/"));
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        JdbcTemplate jdbc = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        String sql = "insert into t_user(user_id,user_name,credits,password) values(2,'liang',100,123)";
        jdbc.update(sql);
    }
}
