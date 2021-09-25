
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Thao tác select
 * Truy vấn và hiện thị dữ liệu
 * Xem file: "Tạo dữ liệu.sql"
 */
public class ThaoTacSelect 
{
    public static void main(String[] args) throws SQLException 
	{
		// 01. Mở kết nối tới CSDL MySQL
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/javacore?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", 
			"username", 
			"password"
		);
		
		// 02. Truy vấn
		// Hiện thị danh sách những học viên có điểm từ 5 trở lên
		// a) Cách 1: Sử dụng Statement
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("select * from HocVien where diem >= 5");
		while (rs.next())
		{
			int stt = rs.getInt("stt");
			String hoten = rs.getString("hoten");
			float diem = rs.getFloat("diem");
			
			System.out.println(stt + ", " + hoten + ", " + diem);
		}
		rs.close();
		stm.close();
		
		// b) Cách 2: Sử dụng PreparedStatement
		PreparedStatement pstm = conn.prepareStatement("select * from HocVien where diem >= ?");
		pstm.setFloat(1, 5f);
		ResultSet rs2 = pstm.executeQuery();
		while (rs2.next())
		{
			int stt = rs2.getInt("stt");
			String hoten = rs2.getString("hoten");
			float diem = rs2.getFloat("diem");
			
			System.out.println(stt + ", " + hoten + ", " + diem);
		}
		rs2.close();
		pstm.close();
		
		// 03. Đóng kết nối
		conn.close();		
	}
}