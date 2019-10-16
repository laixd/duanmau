package model;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KA
 */
public class ProductMODEL {
    private int id;
    private String tensp;
    private float gia;
    private int soluong;
    private Date ngay;

    public ProductMODEL() {
    }

    public ProductMODEL(int id, String tensp, float gia, int soluong, Date ngay) {
        this.id = id;
        this.tensp = tensp;
        this.gia = gia;
        this.soluong = soluong;
        this.ngay = ngay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    
    
    
}
