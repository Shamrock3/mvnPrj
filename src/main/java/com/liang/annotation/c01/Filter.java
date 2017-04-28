package com.liang.annotation.c01;

/**
 * Created by liang on 2017/4/28.
 */
@Table("filter")
public class Filter extends Filter1{
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("email")
    private String email;
    @Column("age")
    private int age;
    public int hhhh;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
