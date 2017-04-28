package com.liang.reflect.c01;

import org.junit.Test;
import org.springframework.context.NoSuchMessageException;

import java.lang.reflect.Field;

/**
 * Created by liang on 2017/4/27.
 */
public class Reflect01 {
    @Test
    public void getField()  throws Exception
    {
        Class clazz = new HistoryBook().getClass();
        HistoryBook historyBook = new HistoryBook();
        Field field = clazz.getDeclaredField("bookName");
        field.setAccessible(true);
        field.set(historyBook,"shiji");
        System.out.println(field.get(historyBook));
    }

}
