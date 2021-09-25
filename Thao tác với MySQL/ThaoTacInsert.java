
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Thao tác insert
 * Thêm dữ liệu mới
 * Xem file: "Tạo dữ liệu.sql"
 */
public class ThaoTacInsert 
{
    public static void main(String[] args) throws SQLException 
	{
		// 01. Mở kết nối tới CSDL MySQL
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/javacore?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", 
			"username", 
			"password"
		);
		
		// 02. Insert
		// Đọc dữ liệu: họ tên + điểm từ bàn phím và thêm vào CSDL
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập họ tên: ");
		String hoten = sc.nextLine();
		System.out.print("Nhập điểm: ");
		float diem = sc.nextFloat(); sc.nextLine();
		
		// a) Cách 1: Sử dụng Statement
		Statement stm = conn.createStatement();
		int n = stm.executeUpdate("insert HocVien(hoten,diem) value ('"+hoten+"', "+diem+")");
		System.out.println("Đã thêm " + n + " dòng");
		stm.close();
		
		// b) Cách 2: Sử dụng PreparedStatement
		PreparedStatement pstm = conn.prepareStatement("insert HocVien(hoten,diem) value (?,?)");
		pstm.setString(1, hoten);
		pstm.setFloat(2, diem);
		int n2 = pstm.executeUpdate();
		System.out.println("Đã thêm " + n2 + " dòng");
		pstm.close();
		
		// 03. Đóng kết nối
		conn.close();		
	}
}