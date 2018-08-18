package com.java.model;

public class SanPham {

    private int ma;
    private static int maTuTang = 1;
    ;
	private float giaNhapVao;
    private String ten;
    private LoaiSanPham loaiSanPham;
    private DonVi donVi;
    private float giaChenhLech = 0;

    public SanPham(String ten) {
        super();
        this.ten = ten;
        this.ma = maTuTang++;
    }

    public void hienThongTin() {
        System.out.println("Ma san pham: " + ma + "\t Ten san pham: " + ten);
    }

    public float getgiaNhapVaoChenhLech() {
        return giaChenhLech;
    }

    public float getGiaNhapVao() {
        return giaNhapVao;
    }

    public void setGiaNhapVao(float giaNhapVao) {
        this.giaNhapVao = giaNhapVao;
    }

    public float getGiaChenhLech() {
        return giaChenhLech;
    }

    public void setGiaChenhLech(float giaChenhLech) {
        this.giaChenhLech = giaChenhLech;
    }

    public void setgiaNhapVaoChenhLech(float giaChenhLech) {
        this.giaChenhLech = giaChenhLech;
    }

    public float giaBanRa() {
        return giaNhapVao + giaChenhLech;
    }

    public SanPham() {
        super();
    }

    public SanPham(int ma, String ten, LoaiSanPham loaiSanPham, DonVi donVi) {
        super();
        this.ma = maTuTang++;
        this.ten = ten;
        this.loaiSanPham = loaiSanPham;
        this.donVi = donVi;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public float getgiaNhapVao() {
        return giaNhapVao;
    }

    public void setgiaNhapVao(float giaNhapVao) {
        this.giaNhapVao = giaNhapVao;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

}
