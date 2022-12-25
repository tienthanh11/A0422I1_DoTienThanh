package com.codegym.ung_dung_muon_sach.error;

public class WrongCodeRent extends Exception {
    public WrongCodeRent(String codeError) {
        super(codeError);
    }
}
