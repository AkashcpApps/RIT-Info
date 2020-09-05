package com.rithassan.info;

public class CourseModel {
    private String Name;
    private  int Photo;
    public CourseModel() {
    }

    public CourseModel(String name, int photo) {
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
