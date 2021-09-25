
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Thao tác Update
 * Xóa dữ liệu trong CSDL
 * Xem file: "Tạo dữ liệu.sql"
 */
public class ThaoTacDelete 
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
		// Đọc dữ liệu: stt từ bàn phím và xóa khỏi CSDL
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập stt của học viên bạn muốn xóa: ");
		int stt = sc.nextInt();
		
		// a) Cách 1: Sử dụng Statement
		Statement stm = conn.createStatement();
		int n = stm.executeUpdate("delete from HocVien where stt="+stt);
		System.out.println("Đã xóa " + n + " dòng");
		stm.close();
		
		// b) Cách 2: Sử dụng PreparedStatement
		PreparedStatement pstm = conn.prepareStatement("delete from HocVien where stt=?");
		pstm.setInt(1, stt);
		int n2 = pstm.executeUpdate();
		System.out.println("Đã xóa " + n2 + " dòng");
		pstm.close();
		
		// 03. Đóng kết nối
		conn.close();		
	}
}