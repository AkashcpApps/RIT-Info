package com.rithassan.info;

public class FacilitiesModel {
    private String Name;
    private  int Photo;
    public FacilitiesModel() {
    }

    public FacilitiesModel(String name, int photo) {
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


