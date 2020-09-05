package com.rithassan.info;

public class StaffModel {
    String name,school,desig,mail,number,image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StaffModel(String name, String school, String desig, String mail, String number, String image) {
        this.name = name;
        this.school = school;
        this.desig = desig;
        this.mail = mail;
        this.number = number;
        this.image = image;
    }

    public StaffModel() {
    }

}
