package com.codegym.phone_manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "smartphones")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String producer;

    @NotBlank
    private String model;

    @NotNull
    @Min(0)
    private Double price;

    @Column(name = "phone_status", columnDefinition = "varchar(5) default 'on'")
    private String status;
}
