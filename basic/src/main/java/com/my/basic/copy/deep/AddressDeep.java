package com.my.basic.copy.deep;

import java.io.Serializable;

/**
 *
 * @author YMa69
 * @date 2019/12/4
 */
public class AddressDeep implements Serializable{

    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
