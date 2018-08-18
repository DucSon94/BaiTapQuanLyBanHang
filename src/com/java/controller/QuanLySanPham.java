package com.java.controller;

import com.java.model.SanPham;
import java.util.HashSet;
import java.util.Set;

public class QuanLySanPham {

    private static Set<SanPham> danhSachSanPham = new HashSet<>();

    public static void themSanPhamVaoDanhSach(SanPham sanPham) {
        danhSachSanPham.add(sanPham);
    }

    public static Set<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public static void setDanhSachSanPham(Set<SanPham> danhSachSanPham) {
        QuanLySanPham.danhSachSanPham = danhSachSanPham;
    }

}
