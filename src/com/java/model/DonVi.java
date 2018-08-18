package com.java.model;

public enum DonVi {
		CAI(1,"Cai"),CHIEC(1,"Chiec");
	
	
	
	private DonVi(int maDonVi, String tenDonVi) {
			this.maDonVi = maDonVi;
			this.tenDonVi = tenDonVi;
		}
	public int getMaDonVi() {
		return maDonVi;
	}
	public void setMaDonVi(int maDonVi) {
		this.maDonVi = maDonVi;
	}
	public String getTenDonVi() {
		return tenDonVi;
	}
	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}
	private int maDonVi;
	private String tenDonVi;
	public static DonVi getDonVi(int chon) {
		switch(chon) {
		case 1:
			return DonVi.CAI;
		default:
			return DonVi.CHIEC;
			
				
		}
		
	}

}
