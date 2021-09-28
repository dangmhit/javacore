package view;

import java.util.Scanner;

/**
 *
 * @author DangMH
 */
public class ManHinhMenuChinh 
{
    public static int hienThi(Scanner sc)
	{
		System.out.println("-------------------------------");
		System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ HỌC VIÊN");
		System.out.println("-------------------------------");
		System.out.println(" 1. Hiện thị danh sách");
		System.out.println(" 2. Tìm kiếm");
		System.out.println(" 3. Thêm mới");
		System.out.println(" 4. Chỉnh sửa");
		System.out.println(" 5. Xóa");
		System.out.println(" 0. Thoát");
		System.out.print("Bạn vui lòng chọn 0-5: ");
		int luachon = sc.nextInt(); sc.nextLine();
		return luachon;
	}
}