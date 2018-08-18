/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.model;

/**
 *
 * @author ducso
 */
public enum GioiTinh {
    NAM(1,"Nam"),NU(-1,"Nu"),KXD(0,"KXD");

    private GioiTinh() {
        
    }

    private GioiTinh(int maGioiTinh, String tenGioiTinh) {
        this.maGioiTinh = maGioiTinh;
        this.tenGioiTinh = tenGioiTinh;
    }
    
    
    private int maGioiTinh;
    private String tenGioiTinh;

    public int getMaGioiTinh() {
        return maGioiTinh;
    }

    public void setMaGioiTinh(int maGioiTinh) {
        this.maGioiTinh = maGioiTinh;
    }

    public String getTenGioiTinh() {
        return tenGioiTinh;
    }

    public void setTenGioiTinh(String tenGioiTinh) {
        this.tenGioiTinh = tenGioiTinh;
    }
    public static GioiTinh getGioiTinh(int maGioitinh){
        switch(maGioitinh){
            case 1:
                return GioiTinh.NAM;
            case -1:
                return GioiTinh.NU;
            default:
                return GioiTinh.KXD;
        }
    }
    
}
