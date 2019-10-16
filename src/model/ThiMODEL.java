/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author KA
 */
public class ThiMODEL {
    private int MaSP;
    private String TenSP;
    private Date NgaySanXuat;
    private int SoLuong;

    public ThiMODEL() {
    }

    public ThiMODEL(int MaSP, String TenSP, Date NgaySanXuat, int SoLuong) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.NgaySanXuat = NgaySanXuat;
        this.SoLuong = SoLuong;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Date getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(Date NgaySanXuat) {
        this.NgaySanXuat = NgaySanXuat;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
