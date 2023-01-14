package com.codegym.demo_spring_security.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(nullable = false, length = 128)
    private String password;

    public Account() {
    }

    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
