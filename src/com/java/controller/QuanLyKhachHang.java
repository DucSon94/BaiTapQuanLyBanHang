/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.controller;

import com.java.model.KhachHang;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ducso
 */
public class QuanLyKhachHang {

    private static Set<KhachHang> danhSachKhachHang = new HashSet<>();

    public static void themKhachHang(KhachHang kh) {
        danhSachKhachHang.add(kh);
    }

    public static Set<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    public static void setDanhSachKhachHang(Set<KhachHang> danhSachKhachHang) {
        QuanLyKhachHang.danhSachKhachHang = danhSachKhachHang;
    }

}
