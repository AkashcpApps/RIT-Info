package com.rithassan.info;

public class Model {
    String image;
    String title;
    String description;
    String time;
    String date;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Model(String link) {
        this.link = link;
    }

    String link;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Model(String image, String title, String description, String time, String date) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.time = time;
        this.date = date;
    }

    public Model() {
    }
}
