package com.java.model;

public class NhanVien {

    private int maNhanVien;
    private static int maTuTang = 1;
    private String tenNhanVien;
    private float doanhThu;
    private float daonhThuTheoThoiGian;

    public float getDaonhThuTheoThoiGian() {
        return daonhThuTheoThoiGian;
    }

    public void setDaonhThuTheoThoiGian(float daonhThuTheoThoiGian) {
        this.daonhThuTheoThoiGian = daonhThuTheoThoiGian;
    }

    public NhanVien() {
        this.maNhanVien = maTuTang++;
    }

    public NhanVien(String tenNhanVien) {
        super();
        this.tenNhanVien = tenNhanVien;
        this.maNhanVien = maTuTang++;
    }

    public NhanVien(int maNhanVien, String tenNhanVien) {
        this.maNhanVien = maTuTang++;
        this.tenNhanVien = tenNhanVien;
    }

    public float doanhThu(SanPham sanPham, int soLuong) {
        return doanhThu = doanhThu + (sanPham.giaBanRa() * soLuong);

    }

    public void hienThongTin() {
        System.out.println("ma: " + maNhanVien + "\t ten: " + tenNhanVien);
    }

    public float getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(float doanhThu) {
        this.doanhThu = doanhThu;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    /*public static NhanVien getNhanVien(int maNhanVien) {
		switch(maNhanVien) {
		case 1:
			return NhanVien.NHANVIEN1;
		case 2:
			return NhanVien.NHANVIEN2;
			default:
				return NhanVien.NHANVIEN3;
						
		}*/

}
