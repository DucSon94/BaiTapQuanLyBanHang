package com.java.view;

import com.java.controller.QuanLyHoaDon;
import com.java.model.HoaDonBanHang;
import com.java.model.HoaDonNhapHang;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        QuanLyHoaDon qlhd = new QuanLyHoaDon();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            System.out.println("1.Tạo hóa đơn nhập hàng");
            System.out.println("2.Tao hó đơn bán hàng");
            System.out.println("3.Hiện thị các hóa đơn nhập hàng");
            System.out.println("4.Hiện thị các hóa đơn bán hàng");
            System.out.println("5.Thống kê tổng tiền nhập hàng theo thời gian ( từ ngày đến ngày)");
            System.out.println("6. Thống kê tổng tiền bán hàng theo thời gian ( từ ngày đến ngày)");
            System.out.println("7.In ra nhân viên có doanh thu cao nhất theo thời gian ( từ ngày đến ngày)");
            //System.out.println("6.In ra cac hoa đon bán hàng");
            int chonChucNang = new Scanner(System.in).nextInt();
            switch (chonChucNang) {
                case 1:
                    HoaDonNhapHang hdnh = new HoaDonNhapHang();
                    Map<String, Integer> danhSachSanPhamNhapVao = hdnh.taoHoaDonNhapHang();
                    hdnh.setDanhSachSanPhamDuocNhapVao(danhSachSanPhamNhapVao);
                    qlhd.themHoaDonNhapHang(hdnh);
                    break;
                case 2:
                    HoaDonBanHang hdbh = new HoaDonBanHang();
                    Map<Integer, Integer> danhSachSanPhamBanRa = hdbh.taoHoaDonBanHang();
                    hdbh.setDanhSachSanPhamDuocBanRa(danhSachSanPhamBanRa);
                    qlhd.themHoaDonBanHang(hdbh);
                    break;
                case 3:
                    qlhd.hienThiThongTinDanhSachHoaDonNhapHang();
                    break;
                case 4:
                    qlhd.hienThiThongTinDanhSachHoaDonBanHang();
                    break;
                case 5:

                    System.out.println("Nhập thời gian bắt đầu: Lưu ý nhập đúng định dạng : dd/MM/yyyy");
                    String thoiGianBatDau = new Scanner(System.in).nextLine();
                    Date date1 = new Date();
                    try {
                        date1 = dateFormatter.parse(thoiGianBatDau);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Nhap thoi gian ket thúc: Lưu ý nhập đúng định dạng  : dd/MM/yyyy");
                    String thoiGianKetThuc = new Scanner(System.in).nextLine();
                    Date date2 = new Date();
                    try {
                        date2 = dateFormatter.parse(thoiGianKetThuc);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    float tongTienNhapHang = qlhd.tongTienNhapHangTrongKhoangThoiGian(date1, date2);
                    System.out.println("Tong tien nhap hang từ: " + thoiGianBatDau + "-->  " + thoiGianKetThuc + "  la: " + tongTienNhapHang);
                    break;
                case 6:
                    System.out.println("Nhập thời gian bắt đầu: Lưu ý nhập đúng định dạng : dd/MM/yyyy");
                    String thoiGianBatDauBanHang = new Scanner(System.in).nextLine();
                    Date dateBanHang1 = new Date();
                    try {
                        dateBanHang1 = dateFormatter.parse(thoiGianBatDauBanHang);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Nhap thoi gian ket thúc: Lưu ý nhập đúng định dạng  : dd/MM/yyyy");
                    String thoiGianKetThucBanHang = new Scanner(System.in).nextLine();
                    Date dateBanHang2 = new Date();
                    try {
                        dateBanHang2 = dateFormatter.parse(thoiGianKetThucBanHang);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();

                    }
                    float tongTienBanHang = qlhd.doanhThuTrongKhoangThoiGian(dateBanHang1, dateBanHang2);
                    System.out.println("Tong tien nhap hang từ: " + thoiGianBatDauBanHang + "-->  " + thoiGianKetThucBanHang + "  la: " + tongTienBanHang);
                    break;
                case 7:
                    System.out.println("Nhập thời gian bắt đầu: Lưu ý nhập đúng định dạng : dd/MM/yyyy");
                    String thoiGian1 = new Scanner(System.in).nextLine();
                    Date date3 = new Date();
                    try {
                        date3 = dateFormatter.parse(thoiGian1);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("Nhap thoi gian ket thúc: Lưu ý nhập đúng định dạng  : dd/MM/yyyy");
                    String thoiGian2 = new Scanner(System.in).nextLine();
                    Date date4 = new Date();
                    try {
                        date4 = dateFormatter.parse(thoiGian2);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    qlhd.nhanVienCoDoanhThuCaoNhatTrongKhoangThoiGian(date3, date4);
                    break;
            }
        }
    }

}
