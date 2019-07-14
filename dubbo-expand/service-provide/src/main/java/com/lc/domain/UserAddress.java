package com.lc.domain;

import java.io.Serializable;

/**
 * Description:
 *
 * @Date:2019/7/14
 * @Author:lc
 */
public class UserAddress implements Serializable{

    private Long id;
    private String userAddress;
    private String consigness;
    private String mobile;

    public UserAddress(Long id, String userAddress, String consigness, String mobile) {
        this.id = id;
        this.userAddress = userAddress;
        this.consigness = consigness;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getConsigness() {
        return consigness;
    }

    public void setConsigness(String consigness) {
        this.consigness = consigness;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userAddress='" + userAddress + '\'' +
                ", consigness='" + consigness + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
