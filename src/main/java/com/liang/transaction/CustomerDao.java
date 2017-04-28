package com.liang.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by liang on 2017/4/27.
 */
@Repository
public class CustomerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


}
