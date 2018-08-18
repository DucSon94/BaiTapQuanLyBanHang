package com.java.model;

public class KhachHang {

    private int maKhachHang;
    private static int maTuTang = 1;
    private String tenKhachHang;
    private GioiTinh gioiTinh;

    public void hienThongTin() {
        System.out.println("Ma khach hang: " + maKhachHang + "\t Ten khach hang: " + tenKhachHang);
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }
    @Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		 if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final KhachHang other = (KhachHang) obj;
	        if ((this.tenKhachHang == null) ? (other.tenKhachHang != null) : !this.tenKhachHang.equals(other.tenKhachHang)) {
	            return false;
	        }
	        if (this.maKhachHang != other.maKhachHang) {
	            return false;
	        }
	        if (this.gioiTinh != other.gioiTinh) {
	            return false;
	        }
		return true;
	}

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public KhachHang() {
        this.maKhachHang = maTuTang++;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public KhachHang(int maKhachHang, String tenKhachHang) {
        super();
        this.maKhachHang = maTuTang++;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
    }

    public KhachHang(String tenKhachHang) {
        this.maKhachHang = maTuTang++;
        this.tenKhachHang = tenKhachHang;
    }

}
