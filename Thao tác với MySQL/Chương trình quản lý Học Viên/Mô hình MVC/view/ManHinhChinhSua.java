package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.HocVien;

public class ManHinhChinhSua 
{
	public static int showAndGetStt(Scanner sc)
	{
		System.out.print("Nhập stt của học viên: ");
		int stt = sc.nextInt(); sc.nextLine();
		return stt;
	}
	
	public static void showNotFound(int stt)
	{
		System.out.println("Không tìm thấy học viên nào có stt là " + stt);
	}
	
	public static void showEditScreen(HocVien hv, Scanner sc) throws Exception
	{
		System.out.println("Thông tin hiện tại của học viên là:");
		HienThiDsHV.printInfo(hv);
			
		System.out.println("Nhập thông tin mới cho học viên:");
		System.out.print("Nhập họ tên mới: ");
		String ten = sc.nextLine();
		hv.setHoTen(ten);
		
		System.out.print("Nhập ngày sinh mới dd/MM/yyyy: ");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date ngaySinh = df.parse(sc.nextLine());
		hv.setNgaySinh(ngaySinh);
		
		System.out.print("Nhập điểm mới: ");
		float diem = sc.nextFloat();
		hv.setDiem(diem);
	}
	
	public static void showSuccessfulSave()
	{
		System.out.println("Đã lưu thành công");
	}
}