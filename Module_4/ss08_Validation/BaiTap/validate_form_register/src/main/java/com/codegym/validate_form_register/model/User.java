package com.codegym.validate_form_register.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Độ dài phải tối thiểu 5 kí tự, tối đa 45 kí tự")
    private String firstName;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Độ dài phải tối thiểu 5 kí tự, tối đa 45 kí tự")
    private String lastName;

    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18")
    private int age;

    @Email
    private String email;

    public User() {
    }

    public User(int id, String firstName,
                @NotBlank(message = "{notEmpty") @Size(min = 5, max = 45, message = "{sizeName}") String lastName,
                String phoneNumber, @Min(value = 18, message = "{age}") int age, @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
