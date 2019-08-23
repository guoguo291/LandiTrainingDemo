package com.landi.trainingdemo.serialization;

/**
 * Created by guoj on 2019/5/26.
 */

public class PersonalInfo {
    private String address;
    private String phone;

    public PersonalInfo(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonalInfo{" +
                "address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
