
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Tạo kết nối tới CSDL MySQL
 * Xem file: "Tạo dữ liệu.sql"
 */
public class KetNoiCSDL 
{
    public static void main(String[] args) throws SQLException 
	{
		// 01. Mở kết nối tới CSDL MySQL
		// Cú pháp:
		//   jdbc:mysql://<host-address>:<host-port>/<schema-name>
		// Ví dụ:
		//   jdbc:mysql://localhost:3306/javacore
		// Note:
		//   Trong quá trình học, chúng ta sử dụng môi trường development trên 
		//   máy localhost, nên có thể gặp các cảnh báo như ko có SSL, ko có 
		//   time zone, lỗi font T/Việt,... thì chúng ta thêm các tham số vào 
		//   cuối như sau:
		//     jdbc:mysql://localhost:3306/javacore?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
		Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/javacore?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", 
			"username", 
			"password"
		);
		System.out.println("Đã kết nối tới MySQL thành công");
		
		// 02. Đóng kết nối
		conn.close();
		System.out.println("Đã đóng kết nối với MySQL thành công");
	}
}