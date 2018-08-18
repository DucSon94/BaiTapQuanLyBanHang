package com.java.model;

public class LoaiSanPham {
private int maLoai;
private int maTuTang =1;
private String tenLoai;

public int getMaLoai() {
	return maLoai;
}

public void setMaLoai(int maLoai) {
	this.maLoai = maLoai;
}

public String getTenLoai() {
	return tenLoai;
}

public void setTenLoai(String tenLoai) {
	this.tenLoai = tenLoai;
}

public LoaiSanPham() {
	this.maLoai = maTuTang++;
}

}
