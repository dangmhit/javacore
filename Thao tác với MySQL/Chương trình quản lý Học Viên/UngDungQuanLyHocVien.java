
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UngDungQuanLyHocVien 
{
    public static void main(String[] args) throws Exception 
	{
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/javacore?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", 
			"username", 
			"password"
		);
		Scanner sc = new Scanner(System.in);
		
		int luachon;
		do
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
			luachon = sc.nextInt(); sc.nextLine();
			switch (luachon)
			{
				case 1: 
					hienThiDanhSach(conn);
					break;					
				case 2: 
					timKiem(conn, sc);
					break;					
				case 3: 
					themMoi(conn, sc);
					break;
				case 4: 
					chinhSua(conn, sc);
					break;
				case 5: 
					xoa(conn, sc);
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
		conn.close();
	}
	
	/**
	 * Hiện thị danh sách
	 */
	public static void hienThiDanhSach(Connection conn) throws SQLException
	{
		System.out.println("DANH SÁCH HỌC VIÊN");
		Statement stm = conn.createStatement();
		
		ResultSet rs = stm.executeQuery("select * from HocVien");
		while (rs.next())
		{
			HocVien hv = new HocVien();
			hv.readInfoFromMysql(rs);
			
			hv.printInfo();
		}
		rs.close();
		
		stm.close();
	}

	/**
	 * Tìm kiếm
	 */
	public static void timKiem(Connection conn, Scanner sc) throws SQLException
	{
		System.out.println("TÌM KIẾM HỌC VIÊN");
		System.out.print("Nhập tên học viên: ");
		String ten = sc.nextLine();
		
		PreparedStatement stm = conn.prepareStatement("select * from HocVien where hoten like ?");
		stm.setString(1, '%' + ten + '%');
		
		ResultSet rs = stm.executeQuery();
		while (rs.next())
		{
			HocVien hv = new HocVien();
			hv.readInfoFromMysql(rs);
			
			hv.printInfo();
		}
		rs.close();
		
		stm.close();
	}

	/**
	 * Thêm mới
	 */
	public static void themMoi(Connection conn, Scanner sc) throws Exception
	{
		HocVien hv = new HocVien();
		hv.readInfoFromKeyboard(sc);
		hv.insertToMysql(conn);
		System.out.println("Đã thêm thành công");
	}
	
	/**
	 * Chỉnh sửa
	 */
	public static void chinhSua(Connection conn, Scanner sc) throws Exception
	{
		System.out.print("Nhập stt của học viên: ");
		int stt = sc.nextInt(); sc.nextLine();
		
		HocVien hv = null;
		Statement stm = conn.createStatement();		
		ResultSet rs = stm.executeQuery("select * from HocVien where stt=" + stt);
		if (rs.next())
		{
			hv = new HocVien();
			hv.readInfoFromMysql(rs);
		}
		rs.close();		
		stm.close();
		
		if (hv == null)
			System.out.println("Không tìm thấy học viên nào có stt là " + stt);
		else
		{
			System.out.println("Thông tin hiện tại của học viên là:");
			hv.printInfo();
			
			System.out.println("Nhập thông tin mới cho học viên:");
			hv.readInfoFromKeyboard(sc);			
			hv.saveToMysql(conn);
			System.out.println("Đã lưu thành công");
		}
	}
	
	/**
	 * Xóa
	 */
	public static void xoa(Connection conn, Scanner sc) throws Exception
	{
		System.out.print("Nhập stt của học viên: ");
		int stt = sc.nextInt(); sc.nextLine();
		
		Statement stm = conn.createStatement();	
		int n = stm.executeUpdate("delete from HocVien where stt=" + stt);
		if (n > 0)
			System.out.println("Đã xóa");
		else
			System.out.println("Không tìm thấy học viên nào có stt là " + stt);
	}
}