package com.rithassan.info;

public class Model3 {
    String name,school,desig,image;

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



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Model3(String name, String school, String desig,String image) {
        this.name = name;
        this.school = school;
        this.desig = desig;

        this.image = image;
    }

    public Model3() {
    }

}