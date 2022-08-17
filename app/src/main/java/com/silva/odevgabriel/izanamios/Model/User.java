package com.silva.odevgabriel.izanamios.Model;

import java.io.Serializable;

public class User implements Serializable {

    private String nickname;
    private String name;
    private String lastName;
    private String email;
    private String avatar;
    private String state;
    private String password;
    private String born;

    public User() {}

    public User(
            String nickname,
            String name,
            String lastName,
            String email,
            String avatar,
            String state,
            String born,
            String password
    ) {
        this.nickname = nickname;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
        this.state = state;
        this.born = born;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", state='" + state + '\'' +
                ", password='" + password + '\'' +
                ", born='" + born + '\'' +
                '}';
    }
}
