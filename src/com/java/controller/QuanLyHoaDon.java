package com.java.controller;

import com.java.controller.QuanLyNhanVien;
import com.java.model.HoaDonBanHang;
import com.java.model.HoaDonNhapHang;
import com.java.model.NhanVien;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QuanLyHoaDon {

    private static ArrayList<HoaDonBanHang> danhSachHoaDonBanHang = new ArrayList<>();
    private static ArrayList<HoaDonNhapHang> danhSachHoaDonNhapHang = new ArrayList<>();

    public void themHoaDonNhapHang(HoaDonNhapHang hdnh) {
        danhSachHoaDonNhapHang.add(hdnh);
    }

    public void themHoaDonBanHang(HoaDonBanHang hdbh) {
        danhSachHoaDonBanHang.add(hdbh);
    }

    public void hienThiThongTinDanhSachHoaDonNhapHang() {
        if (danhSachHoaDonNhapHang.size() > 0) {
            for (HoaDonNhapHang hoaDonNhapHang : danhSachHoaDonNhapHang) {
                hoaDonNhapHang.InHoaDonNhapHang();
            }
        } else {
            System.out.println("Không có thông tin hóa đơn nhập hàng nào");
        }
    }

    public void hienThiThongTinDanhSachHoaDonBanHang() {
        if (danhSachHoaDonBanHang.size() > 0) {
            for (HoaDonBanHang hoaDonBanHang : danhSachHoaDonBanHang) {
                hoaDonBanHang.inHoaDonBanHang();
            }
        } else {
            System.out.println("Không có thông tin hóa đơn bán hàng nào");
        }
    }

    public float doanhThuTrongKhoangThoiGian(Date date1, Date date2) {
        float doanhThuTheoThoiGian = 0;
        if (danhSachHoaDonBanHang != null) {
            for (HoaDonBanHang hoaDon : danhSachHoaDonBanHang) {
                if (hoaDon.getDateBanHang().compareTo(date1) >= 0 && hoaDon.getDateBanHang().compareTo(date2) <= 0) {
                    doanhThuTheoThoiGian += hoaDon.doanhThu();
                }

            }
            return doanhThuTheoThoiGian;
        }
        return doanhThuTheoThoiGian;

    }

    public float tongTienNhapHangTrongKhoangThoiGian(Date date1, Date date2) {
        float tongTienNhapHangTrongKhoangThoiGian = 0;
        if (danhSachHoaDonNhapHang != null) {
            for (HoaDonNhapHang hoaDon : danhSachHoaDonNhapHang) {
                tongTienNhapHangTrongKhoangThoiGian += hoaDon.tienNhapHang();
            }
            return tongTienNhapHangTrongKhoangThoiGian;
        }
        return tongTienNhapHangTrongKhoangThoiGian;

    }

    public static ArrayList<HoaDonBanHang> getDanhSachHoaDonBanHang() {
        return danhSachHoaDonBanHang;
    }

    public static void setDanhSachHoaDonBanHang(ArrayList<HoaDonBanHang> danhSachHoaDonBanHang) {
        QuanLyHoaDon.danhSachHoaDonBanHang = danhSachHoaDonBanHang;
    }

    public void nhanVienCoDoanhThuCaoNhatTrongKhoangThoiGian(Date date1, Date date2) {

        if (danhSachHoaDonBanHang.size() > 0) {
            Set<NhanVien> danhSach1 = null;
            ArrayList<HoaDonBanHang> danhSachHoaDon = new ArrayList<>();
            for (HoaDonBanHang hoaDonBanHang : danhSachHoaDonBanHang) {
                if (hoaDonBanHang.getDateBanHang().compareTo(date1) >= 0 && hoaDonBanHang.getDateBanHang().compareTo(date2) <= 0) {
                    danhSachHoaDon.add(hoaDonBanHang);
                }

            }
            Iterator<NhanVien> danhSachNhanVien = QuanLyNhanVien.getDanhSachNhanVien().iterator();

            NhanVien nv = null;

            for (int i = 0; i < danhSachHoaDon.size(); i++) {
                HoaDonBanHang hd = danhSachHoaDon.get(i);
                float doanhThu = 0;
                /*while(danhSachNhanVien.hasNext()) {
				nv= danhSachNhanVien.next();*/
 /*if(hoaDonBanHang.getNhanVienBanHang()==nv) {
					doanhThu =nv.getDaonhThuTheoThoiGian()+ hoaDonBanHang.doanhThu();*/
 /*nv.setDaonhThuTheoThoiGian(doanhThu);
					danhSach1.add(nv);*/
                //
                if (danhSach1 != null) {
                    Iterator<NhanVien> danhSachNhanVien2 = danhSach1.iterator();
                    while (danhSachNhanVien2.hasNext()) {
                        NhanVien nv2 = null;
                        nv = danhSachNhanVien2.next();
                        nv2 = hd.getNhanVienBanHang();
                        if (nv.equals(nv2)) {
                            doanhThu = nv.getDaonhThuTheoThoiGian() + hd.doanhThu();

                            //if(danhSach1.contains(nv2)) {
                            danhSach1.remove(nv2);
                            nv.setDaonhThuTheoThoiGian(doanhThu);
                            danhSach1.add(nv);
                            break;
                        } else {
                            //nv= hd.getNhanVienBanHang();
                            nv = nv2;
                            doanhThu = hd.doanhThu();
                            nv.setDaonhThuTheoThoiGian(doanhThu);
                            danhSach1.add(nv);
                            break;
                        }

                        //}
                    }
                } else {
                    danhSach1 = new HashSet<>();
                    nv = hd.getNhanVienBanHang();
                    doanhThu = hd.doanhThu();
                    nv.setDaonhThuTheoThoiGian(doanhThu);
                    danhSach1.add(nv);

                }

                //break;
                //}
            }

            Iterator<NhanVien> danhSach2 = danhSach1.iterator();
            float doanhThuMax = 0;
            NhanVien nv1 = null;
            NhanVien nhanVienDoanhThuCaoNhat = null;
            while (danhSach2.hasNext()) {
                nv1 = danhSach2.next();
                if (nv1.getDaonhThuTheoThoiGian() > doanhThuMax) {
                    nhanVienDoanhThuCaoNhat = nv1;
                    doanhThuMax = nhanVienDoanhThuCaoNhat.getDaonhThuTheoThoiGian();
                }
            }
            System.out.println("Nhan vien co danh thu cao nhat la: ");
            nhanVienDoanhThuCaoNhat.hienThongTin();
            System.out.println("Voi doanh thu la: " + nhanVienDoanhThuCaoNhat.getDaonhThuTheoThoiGian());
            nv.setDaonhThuTheoThoiGian(0);
        } else {
            System.out.println("Khong tim thay du lieu");
        }
    }

}
