package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import model.HocVien;
import model.ThaoTacMySQL;
import view.HienThiDsHV;
import view.ManHinhMenuChinh;
import view.ManHiinhThemHocVien;
import view.ManHinhTImKiem;
import view.ManHinhChinhSua;
import view.ManHinhXoa;

/**
 *
 * @author DangMH
 */
public class ThucHanhMVC 
{
    public static void main(String[] args) throws Exception
	{
		ThaoTacMySQL.open();
		Scanner sc = new Scanner(System.in);
		
		int luachon;
		do
		{
			luachon = ManHinhMenuChinh.hienThi(sc);
			switch (luachon)
			{
				case 1: 
					hienThiDanhSach();
					break;					
				case 2: 
					timKiem(sc);
					break;					
				case 3: 
					themMoi(sc);
					break;
				case 4: 
					chinhSua(sc);
					break;
				case 5: 
					xoa(sc);
					break;
				case 0:
					System.out.println("Goodbye...");
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ");
			}
		}
		while (luachon != 0);
		
		sc.close();
		ThaoTacMySQL.close();
	}
	
	
	/**
	 * Hiện thị danh sách
	 */
	private static void hienThiDanhSach() throws SQLException
	{
		List<HocVien> ls = ThaoTacMySQL.getAll();
		HienThiDsHV.show(ls);
	}

	/**
	 * Tìm kiếm
	 */
	private static void timKiem(Scanner sc) throws SQLException
	{
		String ten = ManHinhTImKiem.showSearchScreen(sc);
		List<HocVien> ls = ThaoTacMySQL.searchByName(ten);
		ManHinhTImKiem.showSearchResult(ls);
	}
	
	private static void themMoi(Scanner sc) throws Exception
	{
		HocVien hv = new HocVien();
		ManHiinhThemHocVien.show(hv, sc);
		ThaoTacMySQL.inset(hv);
		System.out.println("Đã thêm thành công");
	}
	
	private static void chinhSua(Scanner sc) throws Exception
	{
		int stt = ManHinhChinhSua.showAndGetStt(sc);
		HocVien hv = ThaoTacMySQL.getByStt(stt);
		
		if (hv == null)
			ManHinhChinhSua.showNotFound(stt);
		else
		{
			ManHinhChinhSua.showEditScreen(hv, sc);
			ThaoTacMySQL.save(hv);
			ManHinhChinhSua.showSuccessfulSave();
		}
	}
	
	/**
	 * Xóa
	 */
	private static void xoa(Scanner sc) throws Exception
	{
		int stt = ManHinhXoa.showAndGetStt(sc);
		int n = ThaoTacMySQL.delete(stt);
		ManHinhXoa.showDeleteResult(n, stt);
	}
}