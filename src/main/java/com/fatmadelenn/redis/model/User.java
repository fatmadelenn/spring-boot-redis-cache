package com.fatmadelenn.redis.model;

import java.io.Serializable;

public class User implements Serializable {
    public enum Gender {
        MALE, FEMALE
    }

    private String id;
    private String name;
    private Gender gender;

    public User(String id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
