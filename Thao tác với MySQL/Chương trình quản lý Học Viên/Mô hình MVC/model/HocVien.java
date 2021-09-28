package model;


import java.util.Date;

public class HocVien 
{
	private int stt;
	private String hoTen;
	private Date ngaySinh;
	private float diem;
	
	public HocVien()
	{
		this.stt = -1;
		this.hoTen = null;
		this.ngaySinh = null;
		this.diem = -1;
	}

	public int getStt() {
		return stt;
	}

	public String getHoTen() {
		return hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public float getDiem() {
		return diem;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}
}