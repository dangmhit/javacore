package view;

import java.util.Scanner;

public class ManHinhXoa 
{
	public static int showAndGetStt(Scanner sc)
	{
		System.out.print("Nhập stt của học viên muốn xóa: ");
		int stt = sc.nextInt(); sc.nextLine();
		return stt;
	}

	public static void showDeleteResult(int n, int stt)
	{
		if (n > 0)
			System.out.println("Đã xóa");
		else
			System.out.println("Không tìm thấy học viên nào có stt là " + stt);
	}
}