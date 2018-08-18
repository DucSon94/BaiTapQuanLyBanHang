package com.java.model;

import com.java.controller.QuanLySanPham;
import com.java.controller.QuanLyNhanVien;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.java.controller.QuanLyKhachHang;

public class HoaDonNhapHang {

    private int maHoaDon;
    private static int maTuTang = 1;

    private Date dateMuaHang;
    private NhanVien nhanVien;

    private Map<String, Integer> danhSachSanPhamDuocNhapVao = new HashMap<>();

    public Map<String, Integer> getDanhSachSanPhamDuocNhapVao() {
        return danhSachSanPhamDuocNhapVao;
    }

    public void setDanhSachSanPhamDuocNhapVao(Map<String, Integer> danhSachSanPhamDuocNhapVao) {
        this.danhSachSanPhamDuocNhapVao = danhSachSanPhamDuocNhapVao;
    }

    public HoaDonNhapHang() {
        this.maHoaDon = maTuTang++;
    }

    public Map<String, Integer> taoHoaDonNhapHang() {
        Map<String, Integer> danhSachSanPhamDuocNhapVao1 = new HashMap<>();
        while (true) {
            SanPham sp2 = null;
            int soLuong = 0;
            System.out.println("Nhap ten san pham: ");
            String tenSanPham = new Scanner(System.in).nextLine();

            Set<SanPham> danhSach = QuanLySanPham.getDanhSachSanPham();
            int sanPhamDaTonTai = 0;
            if (danhSach != null) {
                Iterator<SanPham> interator = danhSach.iterator();
                SanPham sp1;

                while (interator.hasNext()) {
                    sp1 = interator.next();
                    if (sp1.getTen().equals(tenSanPham)) {
                        sp2 = sp1;
                        sanPhamDaTonTai++;
                        break;
                    }
                }

                if (sanPhamDaTonTai > 0) {

                    System.out.println("Nhap gia san pham nhap vao: ");
                    float giaNhapVao = new Scanner(System.in).nextFloat();
                    System.out.println("nhap so luong: ");
                    soLuong = new Scanner(System.in).nextInt();
                    sp2.setgiaNhapVao(giaNhapVao);
                    danhSachSanPhamDuocNhapVao1.put(tenSanPham, soLuong);
                    System.out.println("1. de nhap them san pham vao hoa don 2.thoat ra");
                    int chonChucNang = new Scanner(System.in).nextInt();
                    switch (chonChucNang) {
                        case 1:
                            return taoHoaDonNhapHang();

                        case 2:
                            break;

                    }
                } else {
                    sp2 = new SanPham(tenSanPham);
                    QuanLySanPham.themSanPhamVaoDanhSach(sp2);
                    System.out.println("Nhap gia san pham nhap vao: ");
                    float giaNhapvao = new Scanner(System.in).nextFloat();
                    sp2.setgiaNhapVao(giaNhapvao);
                    System.out.println("Nhap so luong:");
                    soLuong = new Scanner(System.in).nextInt();
                    danhSachSanPhamDuocNhapVao1.put(tenSanPham, soLuong);
                    System.out.println("1. de nhap them san pham vao hoa don 2.thoat ra");
                    int chonChucNang = new Scanner(System.in).nextInt();
                    switch (chonChucNang) {
                        case 1:
                            return taoHoaDonNhapHang();

                        case 2:
                            break;

                    }
                }
            } else {
                sp2 = new SanPham(tenSanPham);
                System.out.println("Nhap so luong:");
                soLuong = new Scanner(System.in).nextInt();
                danhSachSanPhamDuocNhapVao1.put(tenSanPham, soLuong);
                System.out.println("1. de nhap them san pham vao hoa don 2.thoat ra");
                int chonChucNang = new Scanner(System.in).nextInt();
                switch (chonChucNang) {
                    case 1:
                        return taoHoaDonNhapHang();

                    case 2:
                        break;
                }
            }
            System.out.println("nhap ten nhan vien: ");
            String tenNhanvien = new Scanner(System.in).nextLine();
            NhanVien nv = null;
            Set<NhanVien> danhSachNhanVien = QuanLyNhanVien.getDanhSachNhanVien();
            if (danhSachNhanVien.size() > 0) {

                Iterator<NhanVien> iterator = danhSachNhanVien.iterator();
                NhanVien nhanVien = null;;
                List<NhanVien> danhSachNhanVienCoCungTen = new ArrayList<>();
                while (iterator.hasNext()) {
                    nhanVien = iterator.next();
                    if (nhanVien.getTenNhanVien().equals(tenNhanvien)) {
                        nv = nhanVien;
                        danhSachNhanVienCoCungTen.add(nv);
                        nv.hienThongTin();
                    }

                    System.out.println("neu ban la nhan vien da co trong dnah sach vui long bam 1 . neu la nhan vien moi vui long bam 2");
                    int luaChon = new Scanner(System.in).nextInt();
                    switch (luaChon) {
                        case 1:
                            System.out.println("Vui long chon ma nhan vien tuong ung");
                            for (NhanVien nhanVien2 : danhSachNhanVienCoCungTen) {
                                nhanVien2.hienThongTin();

                            }
                            int maNhanVien = new Scanner(System.in).nextInt();
                            nv = danhSachNhanVienCoCungTen.get(maNhanVien - 1);
                            this.nhanVien = nv;

                            break;
                        case 2:
                            nv = new NhanVien(tenNhanvien);
                            this.nhanVien = nv;
                            QuanLyNhanVien.themNhanVien(nv);
                            break;
                    }
                }
            } else {
                nv = new NhanVien(tenNhanvien);
                QuanLyNhanVien.themNhanVien(nv);

            }

            System.out.println("Nhap thoi gian nhap hang: nhap theo dung dinh dang: dd/MM/yyyy ");
            String thoiGianNhapHang = new Scanner(System.in).nextLine();
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.dateMuaHang = dateFormatter.parse(thoiGianNhapHang);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return danhSachSanPhamDuocNhapVao1;
        }

    }

    public void InHoaDonNhapHang() {
        Set<SanPham> danhSachSanPham = QuanLySanPham.getDanhSachSanPham();
        System.out.println("ma hoa don: " + maHoaDon + "\t Ten nhan vien nhap hang: " + nhanVien.getTenNhanVien());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String thoiGianNhapHang = dateFormatter.format(dateMuaHang);
        System.out.println("Thoi gian nhap hang: " + thoiGianNhapHang);
        System.out.println("danh sach hang da nhap:");
        Set<String> danhSachKey = danhSachSanPhamDuocNhapVao.keySet();
        for (String key : danhSachKey) {
            Iterator<SanPham> danhSach = danhSachSanPham.iterator();
            SanPham sp;
            while (danhSach.hasNext()) {
                sp = danhSach.next();
                if (sp.getTen().equals(key)) {
                    sp.hienThongTin();
                }
            }
            Integer soLuong = danhSachSanPhamDuocNhapVao.get(key);
            System.out.println(" so luong : " + soLuong);
        }
    }

    public void hienThongTinHoaDonNhapVao() {
        System.out.println("ma hoa don: " + maHoaDon + "\t Ten nahn vien nhap hang: " + nhanVien.getTenNhanVien());
        Set<String> danhSachKey = danhSachSanPhamDuocNhapVao.keySet();
        for (String key : danhSachKey) {
            Integer soLuong = danhSachSanPhamDuocNhapVao.get(key);
            System.out.println(key + " : " + soLuong);
        }
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getDateMuaHang() {
        return dateMuaHang;
    }

    public void setDateMuaHang(Date dateMuaHang) {
        this.dateMuaHang = dateMuaHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public float tienNhapHang() {
        float tienNhapHang = 0;
        if (danhSachSanPhamDuocNhapVao != null) {
            Set<String> danhSachTenSanPham = danhSachSanPhamDuocNhapVao.keySet();
            Iterator<SanPham> danhSachSanPham = QuanLySanPham.getDanhSachSanPham().iterator();
            SanPham sp = null;
            for (String key : danhSachTenSanPham) {
                while (danhSachSanPham.hasNext()) {
                    sp = danhSachSanPham.next();
                    if (sp.getTen().equals(key)) {
                        break;
                    }
                }

                Integer soLuong = danhSachSanPhamDuocNhapVao.get(key);
                tienNhapHang += sp.getgiaNhapVao() * soLuong;
            }
        }
        return tienNhapHang;
    }

}
