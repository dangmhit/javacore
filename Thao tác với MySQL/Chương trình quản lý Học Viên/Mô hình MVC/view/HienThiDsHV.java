package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.HocVien;

public class HienThiDsHV 
{
	public static void show(List<HocVien> ls)
	{
		System.out.println("DANH SÁCH TẤT CẢ HỌC VIÊN");
		for (HocVien hv : ls)
		{
			printInfo(hv);
//			String hoten = hv.getHoTen();
//			float diem = hv.getDiem();
//			System.out.println("hoten = " + hoten);
//			System.out.println("diem = " + diem);
		}
	}
	
	public static void printInfo(HocVien hv)
	{
		int stt = hv.getStt();
		String hoTen = hv.getHoTen();
		Date ngaySinh = hv.getNgaySinh();
		float diem = hv.getDiem();
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(
				(stt >= 0 ? stt : "") + ", "
			+	(hoTen == null ? "" : hoTen) + ", "
			+	(ngaySinh == null ? "" : df.format(ngaySinh)) + ", "
			+	(diem >= 0 ? diem : "")
		);
	}
}