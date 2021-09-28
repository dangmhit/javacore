package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ThaoTacMySQL 
{
	private static Connection conn;
	
	public static void open() throws SQLException
	{
		conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/javacore?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", 
			"username", 
			"password"
		);
	}
	
	public static void close() throws SQLException
	{
		conn.close();
	}
	
	public static List<HocVien> getAll() throws SQLException
	{
		List<HocVien> ls = new LinkedList<>();
		
		Statement stm = conn.createStatement();		
		ResultSet rs = stm.executeQuery("select * from HocVien");
		while (rs.next())
		{
			HocVien hv = new HocVien();
			set(hv, rs);
			
			ls.add(hv);
		}
		rs.close();		
		stm.close();
		
		return ls;
	}
	
	public static List<HocVien> searchByName(String ten) throws SQLException
	{
		List<HocVien> ls = new LinkedList<>();
		
		PreparedStatement stm = conn.prepareStatement("select * from HocVien where hoten like ?");
		stm.setString(1, '%' + ten + '%');
		
		ResultSet rs = stm.executeQuery();
		while (rs.next())
		{
			HocVien hv = new HocVien();
			set(hv, rs);
			
			ls.add(hv);
		}
		rs.close();		
		stm.close();
		
		return ls;
	}

	public static void inset(HocVien hv) throws SQLException
	{
		// đổi từ java.util.Date sang java.sql.Date
		java.sql.Date dateInSql = new java.sql.Date(hv.getNgaySinh().getTime());
		
		// execute insert
		PreparedStatement stm = conn.prepareStatement(
			"insert into HocVien(hoten, ngaysinh, diem) value (?,?,?)"
		);
		stm.setString(1, hv.getHoTen());
		stm.setDate(2, dateInSql);
		stm.setFloat(3, hv.getDiem());
		stm.executeUpdate();
		stm.close();
	}

	public static HocVien getByStt(int stt) throws SQLException
	{
		HocVien hv = null;
		Statement stm = conn.createStatement();		
		ResultSet rs = stm.executeQuery("select * from HocVien where stt=" + stt);
		if (rs.next())
		{
			hv = new HocVien();
			set(hv, rs);
		}
		rs.close();		
		stm.close();
		
		return hv;
	}
	
	public static void save(HocVien hv) throws Exception
	{
		// đổi từ java.util.Date sang java.sql.Date
		java.sql.Date dateInSql = new java.sql.Date(hv.getNgaySinh().getTime());
		
		// execute insert
		PreparedStatement stm = conn.prepareStatement(
			"update HocVien set hoten=?, ngaysinh=?, diem=? where stt=?"
		);
		stm.setString(1, hv.getHoTen());
		stm.setDate(2, dateInSql);
		stm.setFloat(3, hv.getDiem());
		stm.setInt(4, hv.getStt());
		stm.executeUpdate();
		stm.close();
	}
	
	public static int delete(int stt) throws Exception
	{
		Statement stm = conn.createStatement();	
		int n = stm.executeUpdate("delete from HocVien where stt=" + stt);
		return n;
	}
	
	private static void set(HocVien hv, ResultSet rs) throws SQLException
	{
		int stt = rs.getInt("stt");
		hv.setStt(stt);
		
		String hoTen = rs.getString("hoten");
		hv.setHoTen(hoTen);
		
		Date ngaySinh = rs.getDate("ngaysinh");
		hv.setNgaySinh(ngaySinh);
		
		float diem = rs.getFloat("diem");
		hv.setDiem(diem);
	}
}