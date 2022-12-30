package com.codegym.demo_session_cookie.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassName {

    @Id
    @Column(length = 20)
    private String classCode;
    private String className;

    @OneToMany(mappedBy = "className", fetch = FetchType.LAZY)
    private Set<Student> students;

    public ClassName() {
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
