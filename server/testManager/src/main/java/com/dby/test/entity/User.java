package com.dby.test.entity;


/**
 * Created by Administrator on 2017/12/28.
 */

public class User implements Comparable<User> {

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;

    private Integer age;

    @Override
    public int compareTo(User o) {
        return this.getAge() >= o.getAge() ? 1 : -1;
    }
}
