package com.lc.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Description:
 *
 * @Date:2019/7/14
 * @Author:lc
 */
public class UserOrder implements Serializable {

    private Long id;
    private String goods;
    private Long price;
    private List<UserAddress> userAddressList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<UserAddress> getUserAddressList() {
        return userAddressList;
    }

    public void setUserAddressList(List<UserAddress> userAddressList) {
        this.userAddressList = userAddressList;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", goods='" + goods + '\'' +
                ", price=" + price +
                ", userAddressList=" + userAddressList +
                '}';
    }
}
