package com.lc.domain;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2019/9/2
 * @Author:lc
 */
public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private Integer wages;
    private Boolean sex;

    public User() {
    }

    public User(Long id, Integer wages) {
        this.id = id;
        this.wages = wages;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) {
        this.wages = wages;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
