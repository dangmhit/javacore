
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HocVien 
{
	private int stt;
	private String hoTen;
	private Date ngaySinh;
	private float diem;
	
	public HocVien()
	{
		this.stt = -1;
		this.hoTen = null;
		this.ngaySinh = null;
		this.diem = -1;
	}
	
	public void readInfoFromKeyboard(Scanner sc) throws ParseException
	{
		System.out.print("Nhập họ tên: ");
		this.hoTen = sc.nextLine();
		
		System.out.print("Nhập ngày sinh dd/MM/yyyy: ");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.ngaySinh = df.parse(sc.nextLine());
		
		System.out.print("Nhập điểm: ");
		this.diem = sc.nextFloat();
	}
	
	public void readInfoFromMysql(ResultSet rs) throws SQLException
	{
		this.stt = rs.getInt("stt");
		this.hoTen = rs.getString("hoten");
		this.ngaySinh = rs.getDate("ngaysinh");
		this.diem = rs.getFloat("diem");
	}
	
	public void insertToMysql(Connection conn) throws SQLException
	{
		// đổi từ java.util.Date sang java.sql.Date
		java.sql.Date dateInSql = new java.sql.Date(ngaySinh.getTime());
		
		// execute insert
		PreparedStatement stm = conn.prepareStatement(
			"insert into HocVien(hoten, ngaysinh, diem) value (?,?,?)"
		);
		stm.setString(1, hoTen);
		stm.setDate(2, dateInSql);
		stm.setFloat(3, diem);
		stm.executeUpdate();
		stm.close();
	}
	
	public void saveToMysql(Connection conn) throws SQLException
	{
		// đổi từ java.util.Date sang java.sql.Date
		java.sql.Date dateInSql = new java.sql.Date(ngaySinh.getTime());
		
		// execute insert
		PreparedStatement stm = conn.prepareStatement(
			"update HocVien set hoten=?, ngaysinh=?, diem=? where stt=?"
		);
		stm.setString(1, hoTen);
		stm.setDate(2, dateInSql);
		stm.setFloat(3, diem);
		stm.setInt(4, stt);
		stm.executeUpdate();
		stm.close();
	}
	
	public void printInfo()
	{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(
				(stt >= 0 ? stt : "") + ", "
			+	(hoTen == null ? "" : hoTen) + ", "
			+	(ngaySinh == null ? "" : df.format(ngaySinh)) + ", "
			+	(diem >= 0 ? diem : "")
		);
	}
}