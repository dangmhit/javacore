
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Thao tác Update
 * Chỉnh sửa dữ liệu trong CSDL
 * Xem file: "Tạo dữ liệu.sql"
 */
public class ThaoTacUpdate 
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
		// Đọc dữ liệu: họ tên + điểm từ bàn phím và sửa trong CSDL
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập stt của học viên bạn muốn sửa thông tin: ");
		int stt = sc.nextInt(); sc.nextLine();
		System.out.print("Nhập họ tên mới: ");
		String hoten = sc.nextLine();
		System.out.print("Nhập điểm mới: ");
		float diem = sc.nextFloat(); sc.nextLine();
		
		// a) Cách 1: Sử dụng Statement
		Statement stm = conn.createStatement();
		int n = stm.executeUpdate("update HocVien set hoten='"+hoten+"', diem="+diem+" where stt="+stt);
		System.out.println("Đã sửa " + n + " dòng");
		stm.close();
		
		// b) Cách 2: Sử dụng PreparedStatement
		PreparedStatement pstm = conn.prepareStatement("update HocVien set hoten=?, diem=? where stt=?");
		pstm.setString(1, hoten);
		pstm.setFloat(2, diem);
		pstm.setInt(3, stt);
		int n2 = pstm.executeUpdate();
		System.out.println("Đã sửa " + n2 + " dòng");
		pstm.close();
		
		// 03. Đóng kết nối
		conn.close();		
	}
}