package view;

import java.util.List;
import java.util.Scanner;
import model.HocVien;

public class ManHinhTImKiem 
{
	public static String showSearchScreen(Scanner sc)
	{
		System.out.println("TÌM KIẾM HỌC VIÊN");
		System.out.print("Nhập tên học viên: ");
		String ten = sc.nextLine();
		
		return ten;
	}
	
	public static void showSearchResult(List<HocVien> ls)
	{
		if (ls.isEmpty())
			System.out.println("Không tìm thấy");
		else
		{
			System.out.println("KẾT QUẢ TÌM KIẾM");
			for (HocVien hv : ls)
			{
				HienThiDsHV.printInfo(hv);
	//			String hoten = hv.getHoTen();
	//			float diem = hv.getDiem();
	//			System.out.println("hoten = " + hoten);
	//			System.out.println("diem = " + diem);
			}
		}
	}
}