import java.util.Scanner;

public abstract class CanBo 
{
	/** Họ tên */
	protected String hoTen;
	
	/** tuổi */
	protected int tuoi;
	
	/** giới tính */
	protected GioiTinh gioiTinh;
	
	/** địa chỉ */
	protected String diaChi;
	
	
	public CanBo()
	{
		this.hoTen = "";
		this.tuoi = -1;
		this.gioiTinh = GioiTinh.KHAC;
		this.diaChi = "";
	}
	
	public String getHoTen()
	{
		return this.hoTen;
	}
	
	/**
	 * Đọc thông tin từ bàn phím
	 * 
	 * @param sc 
	 */
	public void readInfo(Scanner sc)
	{
		System.out.print("Nhap ho ten: ");
		this.hoTen = sc.nextLine();
		
		System.out.print("Nhap tuoi: ");
		this.tuoi = Util.readInt(sc);
		
		System.out.print("Nhap gioi tinh (nam|nu|khac): ");
		String gioitinh = sc.nextLine().trim().toLowerCase();
		switch(gioitinh)
		{
			case "nam": this.gioiTinh = GioiTinh.NAM; break;
			case "nu": this.gioiTinh = GioiTinh.NU; break;
			default: this.gioiTinh = GioiTinh.KHAC;
		}
		
		System.out.print("Nhap dia chi: ");
		this.diaChi = sc.nextLine();
	}
	
	/**
	 * In thông tin ra màn hình
	 */
	public void printInfo()
	{
		System.out.println("Ho ten     : " + this.hoTen);
		System.out.println("Tuoi       : " + this.tuoi);
		System.out.println("Gioi tinh  : " + this.gioiTinh);
		System.out.println("Dia chi    : " + this.diaChi);
	}
}