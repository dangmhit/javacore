package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.HocVien;

public class ManHiinhThemHocVien 
{
	public static void show(HocVien hv, Scanner sc) throws Exception
	{
		System.out.print("Nhập họ tên: ");
		String ten = sc.nextLine();
		hv.setHoTen(ten);
		
		System.out.print("Nhập ngày sinh dd/MM/yyyy: ");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date ngaySinh = df.parse(sc.nextLine());
		hv.setNgaySinh(ngaySinh);
		
		System.out.print("Nhập điểm: ");
		float diem = sc.nextFloat();
		hv.setDiem(diem);
	}
}