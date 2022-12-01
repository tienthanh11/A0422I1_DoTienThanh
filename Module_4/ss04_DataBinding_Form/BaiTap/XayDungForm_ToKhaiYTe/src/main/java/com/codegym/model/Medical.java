package com.codegym.model;

public class Medical {
    private Integer id;
    private String hoTen;
    private String namSinh;
    private String gioiTinh;
    private String quocTich;
    private String soCMND;
    private String tenPhuongTien;
    private String soHieuPhuongTien;
    private String soGhe;
    private String ngayKhoiHanh;
    private String ngayKetThuc;
    private String noiDaDen;
    private String thanhPho;
    private String quan;
    private String phuong;
    private String noiO;
    private String soDienThoai;
    private String email;
    private boolean trieuChungSot;
    private boolean trieuChungHo;
    private boolean trieuChungKhoTho;
    private boolean trieuChungDauHong;
    private boolean trieuChungNon;
    private boolean trieuChungTieuChay;
    private boolean trieuChungXuatHuyet;
    private boolean trieuChungNoiBan;
    private boolean lichSuDenNoiNhiem;
    private boolean lichSuTiepXuc;

    public Medical(){}
    public Medical(Integer id, String hoTen, String namSinh, String gioiTinh, String quocTich, String soCMND, String tenPhuongTien, String soHieuPhuongTien, String soGhe, String ngayKhoiHanh, String ngayKetThuc, String noiDaDen, String thanhPho, String quan, String phuong, String noiO, String soDienThoai, String email, boolean trieuChungSot, boolean trieuChungHo, boolean trieuChungKhoTho, boolean trieuChungDauHong, boolean trieuChungNon, boolean trieuChungTieuChay, boolean trieuChungXuatHuyet, boolean trieuChungNoiBan, boolean lichSuDenNoiNhiem, boolean lichSuTiepXuc) {
        this.id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.soCMND = soCMND;
        this.tenPhuongTien = tenPhuongTien;
        this.soHieuPhuongTien = soHieuPhuongTien;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.noiDaDen = noiDaDen;
        this.thanhPho = thanhPho;
        this.quan = quan;
        this.phuong = phuong;
        this.noiO = noiO;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.trieuChungSot = trieuChungSot;
        this.trieuChungHo = trieuChungHo;
        this.trieuChungKhoTho = trieuChungKhoTho;
        this.trieuChungDauHong = trieuChungDauHong;
        this.trieuChungNon = trieuChungNon;
        this.trieuChungTieuChay = trieuChungTieuChay;
        this.trieuChungXuatHuyet = trieuChungXuatHuyet;
        this.trieuChungNoiBan = trieuChungNoiBan;
        this.lichSuDenNoiNhiem = lichSuDenNoiNhiem;
        this.lichSuTiepXuc = lichSuTiepXuc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }

    public String getSoHieuPhuongTien() {
        return soHieuPhuongTien;
    }

    public void setSoHieuPhuongTien(String soHieuPhuongTien) {
        this.soHieuPhuongTien = soHieuPhuongTien;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getNoiDaDen() {
        return noiDaDen;
    }

    public void setNoiDaDen(String noiDaDen) {
        this.noiDaDen = noiDaDen;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getNoiO() {
        return noiO;
    }

    public void setNoiO(String noiO) {
        this.noiO = noiO;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTrieuChungSot() {
        return trieuChungSot;
    }

    public void setTrieuChungSot(boolean trieuChungSot) {
        this.trieuChungSot = trieuChungSot;
    }

    public boolean isTrieuChungHo() {
        return trieuChungHo;
    }

    public void setTrieuChungHo(boolean trieuChungHo) {
        this.trieuChungHo = trieuChungHo;
    }

    public boolean isTrieuChungKhoTho() {
        return trieuChungKhoTho;
    }

    public void setTrieuChungKhoTho(boolean trieuChungKhoTho) {
        this.trieuChungKhoTho = trieuChungKhoTho;
    }

    public boolean isTrieuChungDauHong() {
        return trieuChungDauHong;
    }

    public void setTrieuChungDauHong(boolean trieuChungDauHong) {
        this.trieuChungDauHong = trieuChungDauHong;
    }

    public boolean isTrieuChungNon() {
        return trieuChungNon;
    }

    public void setTrieuChungNon(boolean trieuChungNon) {
        this.trieuChungNon = trieuChungNon;
    }

    public boolean isTrieuChungTieuChay() {
        return trieuChungTieuChay;
    }

    public void setTrieuChungTieuChay(boolean trieuChungTieuChay) {
        this.trieuChungTieuChay = trieuChungTieuChay;
    }

    public boolean isTrieuChungXuatHuyet() {
        return trieuChungXuatHuyet;
    }

    public void setTrieuChungXuatHuyet(boolean trieuChungXuatHuyet) {
        this.trieuChungXuatHuyet = trieuChungXuatHuyet;
    }

    public boolean isTrieuChungNoiBan() {
        return trieuChungNoiBan;
    }

    public void setTrieuChungNoiBan(boolean trieuChungNoiBan) {
        this.trieuChungNoiBan = trieuChungNoiBan;
    }

    public boolean isLichSuDenNoiNhiem() {
        return lichSuDenNoiNhiem;
    }

    public void setLichSuDenNoiNhiem(boolean lichSuDenNoiNhiem) {
        this.lichSuDenNoiNhiem = lichSuDenNoiNhiem;
    }

    public boolean isLichSuTiepXuc() {
        return lichSuTiepXuc;
    }

    public void setLichSuTiepXuc(boolean lichSuTiepXuc) {
        this.lichSuTiepXuc = lichSuTiepXuc;
    }
}
