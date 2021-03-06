package com.xh.hospitalclient.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {//todo:添加当前挂号次数
    @PrimaryKey
    private String userId;
    private String userPwd;
    private String userName;
    private int userAge;
    private boolean userSex;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(boolean userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                '}';
    }
}
