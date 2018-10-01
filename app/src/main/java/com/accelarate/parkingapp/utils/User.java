package com.accelarate.parkingapp.utils;

/**
 * Created by amritesh.sinha on 9/28/2018.
 */

public class User {

    private String vehicleNo;
    private String userName;
    private String userEmaiId;
    private String userMobileNo;
    private String userPassword;

    public User(String vehicleNo, String userName, String userEmaiId, String userMobileNo, String userPassword) {
        this.vehicleNo = vehicleNo;
        this.userName = userName;
        this.userEmaiId = userEmaiId;
        this.userMobileNo = userMobileNo;
        this.userPassword = userPassword;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmaiId() {
        return userEmaiId;
    }

    public void setUserEmaiId(String userEmaiId) {
        this.userEmaiId = userEmaiId;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
