package com.codegym.demo_webservice_restful.form;

public class StudentForm {
    private String id;
    private String name;
    private String classNameId;
    private String email;
    private String sex;
    private String phoneNumber;

    public StudentForm() {
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

    public String getClassNameId() {
        return classNameId;
    }

    public void setClassNameId(String classNameId) {
        this.classNameId = classNameId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
