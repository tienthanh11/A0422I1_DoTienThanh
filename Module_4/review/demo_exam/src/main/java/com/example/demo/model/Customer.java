package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id_customer")
    @Pattern(regexp = "^KH-[0-9]{3}$", message = "ID is not format: (KH-XXX).")
    private String idCustomer;
    @Column(name = "customer_name")
    @NotBlank(message = "Name is not empty.")
    private String nameCustomer;
    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;
    @Column(name = "birth_day")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)//chuyen string -> date
    private Date birthDay;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "id_card")
    @Pattern(regexp = "^[0-9]{9}$|^[0-9]{12}$", message = "Id card is not format.")
    private String idCard;
    @Column(name = "phone_number")
    @Pattern(regexp = "^090\\d{7}$|^091\\d{7}$|^\\(84\\)\\+90\\d{7}$|^\\(84\\)\\+91\\d{7}$", message = "Phone number is not format.")
    private String phone;
    @Column(name = "email")
    @Email(regexp = "^[a-zA-Z0-9.]+@gmail.com", message = "Email invalidate")
    private String email;
    @Column(name = "address")
    private String address;

    public Customer() {
    }

    public Customer(@Pattern(regexp = "^KH-[1-9]\\d{3}$", message = "ID is not format.") String idCustomer, @NotBlank(message = "Name is not empty.") String nameCustomer, CustomerType customerType, Date birthDay, boolean gender, @Pattern(regexp = "^[0-9]\\d{9}$ || ^[0-9]\\d{12}$", message = "Id card is not format.") String idCard, @Pattern(regexp = "^090\\d{7}$|^091\\d{7}$|^\\(84\\)\\+90\\d{7}$|^\\(84\\)\\+91\\d{7}$", message = "Phone number is not format.") String phone, @Email(regexp = "^[a-z][A-Z][0-9].+@gmail.com") String email, String address) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.customerType = customerType;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
