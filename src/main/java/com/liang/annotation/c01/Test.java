package com.liang.annotation.c01;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by liang on 2017/4/28.
 */
public class Test {
    public static void main(String[] args)
    {
        Filter f1 = new Filter();
        f1.setId("111");
        f1.setAge(13);
        f1.setEmail("11@qq.com,22@sina.com,33@163.com,44@gmail.com");


        String sql = query(f1);

    }


    public static String query(Object obj) {
        StringBuilder sb = new StringBuilder();
        Class clazz = obj.getClass();
        boolean isExists = clazz.isAnnotationPresent(Table.class);
        if(!isExists) {
            return null;
        }
        Table table =(Table) clazz.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("SELECT　* FROM ").append(tableName).append(" WHERE 1 = 1");
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field declaredField : declaredFields) {
            boolean fExists = declaredField.isAnnotationPresent(Column.class);
            if(!fExists){
                continue;
            }
            Column column = declaredField.getAnnotation(Column.class);
            String columnName = column.value();
            String fieldName = declaredField.getName();
            String methodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
            Object returnValue = null;
            try {
                Method method = clazz.getMethod(methodName);
                method.getReturnType();
                returnValue = method.invoke(obj);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(returnValue == null ) {
                continue;
            }
            sb.append(" AND ").append(columnName);
            if(returnValue instanceof String) {
                if(((String) returnValue).contains(",")) {
                    sb.append(" in ").append("(");
                    String[] contains = ((String) returnValue).split(",");
                    for(String contain:contains) {
                        sb.append("'").append(contain).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(") ");
                }
                sb.append(" = ").append("'").append(returnValue.toString()).append("'");
            } else if(returnValue instanceof Integer) {
                sb.append(" = ").append("'").append(returnValue.toString()).append("'");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
