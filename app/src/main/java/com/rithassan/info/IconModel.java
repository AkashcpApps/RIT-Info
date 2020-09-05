package com.rithassan.info;

public class IconModel {
    private String Name;
    private  int Photo;
    public IconModel() {
    }

    public IconModel(String name, int photo) {
        Name = name;
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }
}
