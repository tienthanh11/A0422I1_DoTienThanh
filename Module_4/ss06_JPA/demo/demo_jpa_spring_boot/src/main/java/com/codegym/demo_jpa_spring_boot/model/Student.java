package com.codegym.demo_jpa_spring_boot.model;

import javax.persistence.*;

@Entity(name = "student")
public class Student {
    @Id
    // Tự động tăng
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer codeStudent;
    @Column(name = "name_student", columnDefinition = "VARCHAR(50)")
    private String nameStudent;
    private Double point;
    private Integer gender;
    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(Integer codeStudent, String nameStudent, Double point, Integer gender) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
