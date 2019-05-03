package com.example.ankurbaranwal.customlistview;

public class User
{
    String name;
    String reg;
    int image;

    public User(String name, String reg, int image) {
        this.name = name;
        this.reg = reg;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getReg() {
        return reg;
    }

    public int getImage() {
        return image;
    }
}
