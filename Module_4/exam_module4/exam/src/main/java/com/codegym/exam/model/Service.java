package com.codegym.exam.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^(MGD)-[\\d]{4}$",message = "Mã giao dịch sai định dạng")
    @NotBlank(message = "Không được để trống")
    private String code;

    @NotNull(message = "Không được để trống")
    private Boolean serviceType;

    @NotNull(message = "Không được để trống")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @NotNull(message = "Không được để trống")
    @Min(value = 500,message = "giá phải lớn hơn 500.000 VND")
    private Double price;

    @NotNull(message = "Không được để trống")
    @Min(value = 20,message = "Diện tích phải lớn hơn 20 m^2")
    private Double area;

    @ManyToOne
    @NotNull(message = "Không được để trống")
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;

    public Service() {
    }

    public Service(Integer id, String code, Boolean serviceType, Date date, Double price, Double area, Customer customer) {
        this.id = id;
        this.code = code;
        this.serviceType = serviceType;
        this.date = date;
        this.price = price;
        this.area = area;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getServiceType() {
        return serviceType;
    }

    public void setServiceType(Boolean serviceType) {
        this.serviceType = serviceType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
