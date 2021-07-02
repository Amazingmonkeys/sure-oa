package com.sure.oa.base;

public class CurrUser {

    private String userId;
    private String userName;
    private String userPhoto;

    public CurrUser(String userId, String userName, String userPhoto) {
        this.userId = userId;
        this.userName = userName;
        this.userPhoto = userPhoto;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
