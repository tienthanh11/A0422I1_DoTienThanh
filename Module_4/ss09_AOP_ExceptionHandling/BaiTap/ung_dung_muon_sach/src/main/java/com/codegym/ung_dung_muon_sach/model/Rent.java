package com.codegym.ung_dung_muon_sach.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rent")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rent {
    @Id
    Integer id;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")
    Book book;
    String status;
}
