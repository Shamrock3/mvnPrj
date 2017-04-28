package com.liang.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liang on 2017/4/27.
 */
@Repository
public class BuyBook {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void buyAbook()
    {
        String sellBokSql = "update book set amount = amount - 1 where name = 'shiji'";
        String paySql = "update customer set money = 123da where name = 'liang'";

        jdbcTemplate.update(sellBokSql);
        jdbcTemplate.update(paySql);



    }
}
