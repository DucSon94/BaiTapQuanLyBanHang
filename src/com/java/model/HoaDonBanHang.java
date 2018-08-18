package com.java.model;

import com.java.controller.QuanLyKhachHang;
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

public class HoaDonBanHang {

    private int maHoaDon;
    private static int maHoaDonTuTang = 1;
    private NhanVien nhanVienBanHang;

    private Date dateBanHang;
    private Map<Integer, Integer> danhSachSanPhamDuocBanRa = new HashMap<>();

    private KhachHang khachHang;

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Map<Integer, Integer> getDanhSachSanPhamDuocBanRa() {
        return danhSachSanPhamDuocBanRa;
    }

    public void setDanhSachSanPhamDuocBanRa(Map<Integer, Integer> danhSachSanPhamDuocBanRa) {
        this.danhSachSanPhamDuocBanRa = danhSachSanPhamDuocBanRa;
    }

    public void inHoaDonBanHang() {
        if (danhSachSanPhamDuocBanRa != null) {
            SimpleDateFormat convertTime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String dateForMat = convertTime.format(dateBanHang);
            System.out.println("Ma hoa don: " + maHoaDon + "\t Ten nhan vien: " + nhanVienBanHang.getTenNhanVien());
            System.out.println("Thong tin khach hang: Ma: " + khachHang.getMaKhachHang() + "\t Ten khach hang: " + khachHang.getTenKhachHang());
            System.out.println("Thoi gian ban hang: " + dateForMat);
            System.out.println("Danh sach hang duoc ban ra:");
            Set<Integer> danhSachkey = danhSachSanPhamDuocBanRa.keySet();
            for (Integer key : danhSachkey) {
                Set<SanPham> danhSachSanPham = QuanLySanPham.getDanhSachSanPham();
                Iterator<SanPham> iteratorSp = danhSachSanPham.iterator();
                SanPham sp = null;
                while (iteratorSp.hasNext()) {
                    sp = iteratorSp.next();
                    if (sp.getMa() == key) {
                        sp.hienThongTin();
                        break;
                    }
                }
                Integer soLuong = danhSachSanPhamDuocBanRa.get(key);
                System.out.println("So luong: " + soLuong);

            }
        } else {
            System.out.println("Khong co hoa don ban hang nao");
        }
    }

    public Map<Integer, Integer> taoHoaDonBanHang() {
        Map<Integer, Integer> danhSachSanPhamDuocBanRa1 = new HashMap<>();
        System.out.println("nhap ma san pham:");
        int maSanPham = new Scanner(System.in).nextInt();
        Set<SanPham> danhSachSanPham = QuanLySanPham.getDanhSachSanPham();
        if (danhSachSanPham != null) {
            Iterator<SanPham> iterator = danhSachSanPham.iterator();
            SanPham sp;
            int maSanPhamTonTai = 0;
            while (iterator.hasNext()) {
                sp = iterator.next();
                if (sp.getMa() == maSanPham) {
                    maSanPhamTonTai++;

                }
            }
            if (maSanPhamTonTai > 0) {
                System.out.println("nhap so luong: ");
                int soLuong = new Scanner(System.in).nextInt();
                danhSachSanPhamDuocBanRa1.put(maSanPham, soLuong);
                System.out.println("Vui long chon 1. de tiep tuc them san pham vao hoa don.  2 thoat ra ");
                int chon = new Scanner(System.in).nextInt();
                switch (chon) {
                    case 1:
                        return taoHoaDonBanHang();
                    case 2:
                        break;
                }

                System.out.println("Nhap ten khach hang: ");
                String tenKhachHang = new Scanner(System.in).nextLine();
                Set<KhachHang> danhSachKhachHang = QuanLyKhachHang.getDanhSachKhachHang();
                if (danhSachKhachHang.size() > 0) {
                    Iterator<KhachHang> interatorKhachHang = danhSachKhachHang.iterator();
                    List<KhachHang> danhSachKhachHangCoCungten = new ArrayList<>();
                    while (interatorKhachHang.hasNext()) {
                        KhachHang khachHang = interatorKhachHang.next();
                        if (khachHang.getTenKhachHang().equals(tenKhachHang)) {
                            khachHang.hienThongTin();
                            danhSachKhachHangCoCungten.add(khachHang);
                        }
                    }

                    KhachHang kh = null;
                    int luaChon = 0;
                    while (luaChon != 1 && luaChon != 2) {
                        System.out.println("Neu ban la 1 trong những khach hang tren thì ấn phím 1 để chọn nếu không phải vui lòng ấn  phím 2");
                        luaChon = new Scanner(System.in).nextInt();
                        switch (luaChon) {

                            case 1:

                                System.out.println("Ban hay chon ma khach hang cua minh");
                                for (KhachHang khachHang : danhSachKhachHangCoCungten) {
                                    khachHang.hienThongTin();
                                }

                                while (!danhSachKhachHangCoCungten.contains(kh)) {
                                    int maKhachHang = new Scanner(System.in).nextInt();
                                    kh = new KhachHang(maKhachHang, tenKhachHang);

                                    kh = new KhachHang(maKhachHang, tenKhachHang);
                                    if (danhSachKhachHangCoCungten.contains(kh)) {
                                        this.khachHang = kh;
                                        QuanLyKhachHang.themKhachHang(kh);
                                        break;
                                    } else {
                                        System.out.println("ma khach hang ban chon k dung vui long chon lai");
                                    }
                                }

                                break;
                            case 2:

                                kh = new KhachHang(tenKhachHang);
                                this.khachHang = kh;
                                QuanLyKhachHang.themKhachHang(kh);
                                break;
                            default:
                                System.out.println("vui long an phim 1 hoac 2");

                        }
                    }
                } else {
                    KhachHang kh1 = new KhachHang(tenKhachHang);
                    this.khachHang = kh1;
                    QuanLyKhachHang.themKhachHang(kh1);
                }
                System.out.println("Nhap ten nhan vien ban hang: ");
                String tenNhanVien = new Scanner(System.in).nextLine();
                Set<NhanVien> danhSachNhanVien = QuanLyNhanVien.getDanhSachNhanVien();
                Iterator<NhanVien> iteratorNV = danhSachNhanVien.iterator();
                int nhanVienCoTrongDanhSach = 0;

                NhanVien nv = null;
                while (iteratorNV.hasNext()) {
                    nv = iteratorNV.next();
                    if (nv.getTenNhanVien().equals(tenNhanVien)) {
                        nhanVienCoTrongDanhSach++;

                        break;
                    }
                }
                if (nhanVienCoTrongDanhSach > 0) {
                    this.nhanVienBanHang = nv;

                } else {
                    this.nhanVienBanHang = new NhanVien(tenNhanVien);
                    QuanLyNhanVien.themNhanVien(nhanVienBanHang);
                }
                System.out.println("Nhap thoi gian ban theo dinh dang: dd/MM/yyyy");
                String thoiGian = new Scanner(System.in).nextLine();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    date = formatter.parse(thoiGian);
                    this.dateBanHang = date;
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } else {
            System.out.println("Ma san pham khong ton tai vui long kiem tra lai");
            System.out.println("Vui long chon 1. de tiep tuc them san pham vao hoa don.  2 thoat ra ");
            int luaChon = new Scanner(System.in).nextInt();
            switch (luaChon) {
                case 1:
                    return taoHoaDonBanHang();
                case 2:
                    break;
            }
        }

        return danhSachSanPhamDuocBanRa1;

    }

    public Map<Integer, Integer> taoHoaDonBanHang1() {
        Map<Integer, Integer> danhSachSanPhamDuocBanRa1 = new HashMap<>();
        System.out.println("nhap ma san pham:");
        int maSanPham = new Scanner(System.in).nextInt();
        Set<SanPham> danhSachSanPham = QuanLySanPham.getDanhSachSanPham();
        if (danhSachSanPham != null) {
            Iterator<SanPham> iterator = danhSachSanPham.iterator();
            SanPham sp;
            int maSanPhamTonTai = 0;
            while (iterator.hasNext()) {
                sp = iterator.next();
                if (sp.getMa() == maSanPham) {
                    maSanPhamTonTai++;

                }
            }
            if (maSanPhamTonTai > 0) {
                System.out.println("nhap so luong: ");
                int soLuong = new Scanner(System.in).nextInt();
                danhSachSanPhamDuocBanRa1.put(maSanPham, soLuong);
                System.out.println("Vui long chon 1. de tiep tuc them san pham vao hoa don.  2 thoat ra ");
                int chon = new Scanner(System.in).nextInt();
                switch (chon) {
                    case 1:
                        return taoHoaDonBanHang();
                    case 2:
                        break;
                }

                System.out.println("Nhap ten khach hang: ");
                String tenKhachHang = new Scanner(System.in).nextLine();
                Set<KhachHang> danhSachKhachHang = QuanLyKhachHang.getDanhSachKhachHang();
                if (danhSachKhachHang.size() > 0) {
                    Iterator<KhachHang> interatorKhachHang = danhSachKhachHang.iterator();
                    List<KhachHang> danhSachKhachHangCoCungten = new ArrayList<>();
                    while (interatorKhachHang.hasNext()) {
                        KhachHang khachHang = interatorKhachHang.next();
                        if (khachHang.getTenKhachHang().equals(tenKhachHang)) {
                            khachHang.hienThongTin();
                            danhSachKhachHangCoCungten.add(khachHang);
                        }
                    }
//	                   
                    KhachHang kh = null;
                    int luaChon = 0;
                    while (luaChon != 1 && luaChon != 2) {
                        System.out.println("Neu ban la 1 trong những khach hang tren thì ấn phím 1 để chọn nếu không phải vui lòng ấn  phím 2");
                        luaChon = new Scanner(System.in).nextInt();
                        switch (luaChon) {

                            case 1:

                                System.out.println("Ban hay chon ma khach hang cua minh");
                                for (KhachHang khachHang : danhSachKhachHangCoCungten) {
                                    khachHang.hienThongTin();
                                }

                                while (!danhSachKhachHangCoCungten.contains(kh)) {
                                    int maKhachHang = new Scanner(System.in).nextInt();
                                    kh = new KhachHang(maKhachHang, tenKhachHang);

                                    kh = new KhachHang(maKhachHang, tenKhachHang);
                                    if (danhSachKhachHangCoCungten.contains(kh)) {
                                        this.khachHang = kh;
                                        QuanLyKhachHang.themKhachHang(kh);
                                        break;
                                    } else {
                                        System.out.println("ma khach hang ban chon k dung vui long chon lai");
                                    }
                                }

                                break;
                            case 2:

                                kh = new KhachHang(tenKhachHang);
                                this.khachHang = kh;
                                QuanLyKhachHang.themKhachHang(kh);
                                break;
                            default:
                                System.out.println("vui long an phim 1 hoac 2");

                        }
                    }
                } else {
                    KhachHang kh1 = new KhachHang(tenKhachHang);
                    this.khachHang = kh1;
                    QuanLyKhachHang.themKhachHang(kh1);
                }
                System.out.println("Nhap ten nhan vien ban hang: ");
                String tenNhanVien = new Scanner(System.in).nextLine();
                Set<NhanVien> danhSachNhanVien = QuanLyNhanVien.getDanhSachNhanVien();
                Iterator<NhanVien> iteratorNV = danhSachNhanVien.iterator();
                int nhanVienCoTrongDanhSach = 0;

                NhanVien nv = null;
                while (iteratorNV.hasNext()) {
                    nv = iteratorNV.next();
                    if (nv.getTenNhanVien().equals(tenNhanVien)) {
                        nhanVienCoTrongDanhSach++;

                        break;
                    }
                }
                if (nhanVienCoTrongDanhSach > 0) {
                    this.nhanVienBanHang = nv;

                } else {
                    this.nhanVienBanHang = new NhanVien(tenNhanVien);
                    QuanLyNhanVien.themNhanVien(nhanVienBanHang);
                }
                System.out.println("Nhap thoi gian ban theo dinh dang: dd/MM/yyyy");
                String thoiGian = new Scanner(System.in).nextLine();
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    date = formatter.parse(thoiGian);
                    this.dateBanHang = date;
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } else {
            System.out.println("Ma san pham khong ton tai vui long kiem tra lai");
            System.out.println("Vui long chon 1. de tiep tuc them san pham vao hoa don.  2 thoat ra ");
            int luaChon = new Scanner(System.in).nextInt();
            switch (luaChon) {
                case 1:
                    return taoHoaDonBanHang();
                case 2:
                    break;
            }
        }

        return danhSachSanPhamDuocBanRa1;

    }

    public HoaDonBanHang() {
        this.maHoaDon = maHoaDonTuTang++;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public NhanVien getNhanVienBanHang() {
        return nhanVienBanHang;
    }

    public void setNhanVienBanHang(NhanVien nhanVienBanHang) {
        this.nhanVienBanHang = nhanVienBanHang;
    }

    public Date getDateBanHang() {
        return dateBanHang;
    }

    public void setDateBanHang(Date dateBanHang) {
        this.dateBanHang = dateBanHang;
    }

    public float doanhThu() {
        float doanhThu = 0;

        if (danhSachSanPhamDuocBanRa != null) {
            Set<Integer> danhSachMaSanPham = danhSachSanPhamDuocBanRa.keySet();
            Iterator<SanPham> danhSachSanPham = QuanLySanPham.getDanhSachSanPham().iterator();

            for (Integer key : danhSachMaSanPham) {
                SanPham sp = null;

                while (danhSachSanPham.hasNext()) {
                    sp = danhSachSanPham.next();
                    if (sp.getMa() == key) {
                        break;
                    }
                }

                Integer soLuong = danhSachSanPhamDuocBanRa.get(key);
                doanhThu += sp.giaBanRa() * soLuong;

            }
        }
        return doanhThu;

    }

}
