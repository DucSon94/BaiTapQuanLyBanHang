package com.java.controller;

import com.java.model.NhanVien;
import java.util.HashSet;
import java.util.Set;

public class QuanLyNhanVien {

    private static Set<NhanVien> danhSachNhanVien = new HashSet<>();

    public static void themNhanVien(NhanVien nhanVien) {
        danhSachNhanVien.add(nhanVien);
    }

    public static Set<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public static void setDanhSachNhanVien(Set<NhanVien> danhSachNhanVien) {
        QuanLyNhanVien.danhSachNhanVien = danhSachNhanVien;
    }

}
