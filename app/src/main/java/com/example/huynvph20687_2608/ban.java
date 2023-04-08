package com.example.huynvph20687_2608;

public class ban {
    private int id;
    private String ten;
    private String ngay;
    private String phongban;

    public ban() {
    }

    public ban(String ten, String ngay, String phongban) {
        this.ten = ten;
        this.ngay = ngay;
        this.phongban = phongban;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }
}
