package com.rithassan.info;

public class Model1 {
    String image,title,description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Model1(String image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;

    }

    public Model1() {
    }
}
